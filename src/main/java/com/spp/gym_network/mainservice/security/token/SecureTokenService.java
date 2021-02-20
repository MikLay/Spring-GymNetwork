package com.spp.gym_network.mainservice.security.token;

import com.spp.gym_network.mainservice.security.jpa.SecureToken;

public interface SecureTokenService {

    SecureToken createSecureToken();
    void saveSecureToken(final SecureToken token);
    SecureToken findByToken(final String token);
    void removeToken(final SecureToken token);
    void removeTokenByToken(final String token);
}
