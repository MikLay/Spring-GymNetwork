package com.spp.gym_network.mainservice.user.jpa.repository;

import com.spp.gym_network.mainservice.user.jpa.data.ERoles;
import com.spp.gym_network.mainservice.user.jpa.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERoles role);
}
