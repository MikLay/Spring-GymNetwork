package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    Optional<UserEntity> findByToken(String token);

    @Query(value = "SELECT u from UserEntity u where u.email = ?1 and u.password = ?2 ")
    Optional<UserEntity> login(String email, String password);
}
