package com.spp.gym_network.mainservice.controller;

import com.spp.gym_network.mainservice.model.user.UserEntity;
import com.spp.gym_network.mainservice.dto.ApiResponse;
import com.spp.gym_network.mainservice.dto.JwtAuthenticationResponse;
import com.spp.gym_network.mainservice.dto.LoginRequest;
import com.spp.gym_network.mainservice.dto.SignUpRequest;
import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;
import com.spp.gym_network.mainservice.security.provider.JwtTokenProvider;
import com.spp.gym_network.mainservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }


    @PostMapping("signup")
    public ResponseEntity<?> registerUser(final @Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            UserEntity user = userService.register(signUpRequest);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{username}")
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("verify")
    public ResponseEntity<?> verifyUser(final @RequestParam(required = false) String token) {
        if (StringUtils.isEmpty(token)) {
            return new ResponseEntity(new ApiResponse(true, "Provide token"), HttpStatus.BAD_REQUEST);
        }
        try {
            userService.verifyUser(token);
        } catch (InvalidTokenException e) {
            return new ResponseEntity(new ApiResponse(false, "Invalid token"), HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity(new ApiResponse(true, "Successfully verified"), HttpStatus.ACCEPTED);

    }

}
