package com.spp.gym_network.mainservice.repo;

import com.spp.gym_network.mainservice.domain.user.ERoles;
import com.spp.gym_network.mainservice.domain.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERoles role);
}
