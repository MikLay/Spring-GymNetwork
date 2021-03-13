package com.spp.gym_network.mainservice.service;


import com.spp.gym_network.mainservice.dto.requests.SignUpRequest;
import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;
import com.spp.gym_network.mainservice.model.user.UserEntity;

public interface UserService {

    UserEntity register(SignUpRequest user) throws UserAlreadyExistException;

    void sendRegistrationConfirmationEmail(UserEntity user);

    boolean checkIfUserExist(String email);

    boolean verifyUser(String token) throws InvalidTokenException;

    UserEntity getUserByEmail(String email);
}
