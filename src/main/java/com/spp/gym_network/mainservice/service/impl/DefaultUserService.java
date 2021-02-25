package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.domain.security.SecureToken;
import com.spp.gym_network.mainservice.domain.user.ERoles;
import com.spp.gym_network.mainservice.domain.user.UserEntity;
import com.spp.gym_network.mainservice.dto.SignUpRequest;
import com.spp.gym_network.mainservice.email.context.AccountVerificationEmailContext;
import com.spp.gym_network.mainservice.email.service.EmailService;
import com.spp.gym_network.mainservice.exceptions.InvalidTokenException;
import com.spp.gym_network.mainservice.exceptions.UserAlreadyExistException;
import com.spp.gym_network.mainservice.repo.RoleRepository;
import com.spp.gym_network.mainservice.repo.SecureTokenRepository;
import com.spp.gym_network.mainservice.repo.UserRepository;
import com.spp.gym_network.mainservice.service.SecureTokenService;
import com.spp.gym_network.mainservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    SecureTokenRepository secureTokenRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SecureTokenService secureTokenService;
    @Value("${gym-service.base-url-https}")
    private String baseURL;

    @Override
    public UserEntity register(SignUpRequest user) throws UserAlreadyExistException {

        //Check if user already registered with us
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        //TODO: add better role logic
        userEntity.setRoles(Stream.of(roleRepository.findByName(ERoles.ROLE_USER))
                .collect(Collectors.toCollection(HashSet::new)));
        encodePassword(userEntity, user);
        UserEntity result = userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);
        return result;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {
        SecureToken secureToken = secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        emailContext.init(user);
        emailContext.setToken(secureToken.getToken());
        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean verifyUser(String token) throws InvalidTokenException {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if (Objects.isNull(secureToken) || !Objects.equals(token, secureToken.getToken()) || secureToken.isExpired()) {
            throw new InvalidTokenException("Token is not valid");
        }
        UserEntity user = userRepository.getOne(secureToken.getUser().getId());
        if (Objects.isNull(user)) {
            return false;
        }
        user.setAccountVerified(true);
        userRepository.save(user); // let's same user details

        // we don't need invalid password now
        secureTokenService.removeToken(secureToken);
        return true;
    }



    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }


    private void encodePassword(UserEntity userEntity, SignUpRequest user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}