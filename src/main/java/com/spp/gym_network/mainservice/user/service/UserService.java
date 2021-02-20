package com.spp.gym_network.mainservice.user.service;


import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;
import com.spp.gym_network.mainservice.user.dto.UserData;
import com.spp.gym_network.mainservice.user.jpa.data.UserEntity;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    void sendRegistrationConfirmationEmail(final UserEntity user);
    boolean checkIfUserExist(final String email);
    boolean verifyUser(final String token) throws InvalidTokenException;
}
