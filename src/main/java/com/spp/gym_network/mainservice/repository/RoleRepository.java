package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.ERole;
import com.spp.gym_network.mainservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
