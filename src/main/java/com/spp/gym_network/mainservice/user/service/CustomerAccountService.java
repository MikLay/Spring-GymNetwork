package com.spp.gym_network.mainservice.user.service;

import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UnkownIdentifierException;

public interface CustomerAccountService {

    void forgottenPassword(final String userName) throws UnkownIdentifierException;
    void updatePassword(final String password, final String token) throws InvalidTokenException, UnkownIdentifierException;
    boolean loginDisabled(final String username);
}
