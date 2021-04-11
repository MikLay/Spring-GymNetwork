package com.spp.gym_network.mainservice.controller;

import com.spp.gym_network.mainservice.dto.ApiResponse;
import com.spp.gym_network.mainservice.dto.JwtAuthenticationResponse;
import com.spp.gym_network.mainservice.dto.request.LoginRequest;
import com.spp.gym_network.mainservice.dto.request.SignUpRequest;
import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;
import com.spp.gym_network.mainservice.model.user.UserEntity;
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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    private UserService userService;

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
    public ResponseEntity<?> registerUser(final @Valid SignUpRequest signUpRequest) throws UserAlreadyExistException {
        UserEntity user = userService.register(signUpRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

    }

    @GetMapping("verify")
    public ResponseEntity<?> verifyUser(final @RequestParam(required = false) @Valid @NotNull String token) throws InvalidTokenException {
        userService.verifyUser(token);
        return new ResponseEntity(new ApiResponse(true, "Successfully verified"), HttpStatus.ACCEPTED);

    }

}
