package com.spp.gym_network.mainservice.user.jpa.repository;

import com.spp.gym_network.mainservice.user.jpa.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
