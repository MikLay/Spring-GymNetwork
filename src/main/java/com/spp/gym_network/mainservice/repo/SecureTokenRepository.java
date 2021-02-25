package com.spp.gym_network.mainservice.repo;

import com.spp.gym_network.mainservice.domain.security.SecureToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureTokenRepository extends JpaRepository<SecureToken, Long > {

    SecureToken findByToken(final String token);
    Long removeByToken(String token);
}
