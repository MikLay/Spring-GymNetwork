package com.spp.gym_network.mainservice.service;


import com.spp.gym_network.mainservice.model.user.UserEntity;
import com.spp.gym_network.mainservice.dto.SignUpRequest;
import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;

public interface UserService {

    UserEntity register(final SignUpRequest user) throws UserAlreadyExistException;

    void sendRegistrationConfirmationEmail(final UserEntity user);

    boolean checkIfUserExist(final String email);

    boolean verifyUser(final String token) throws InvalidTokenException;

}
