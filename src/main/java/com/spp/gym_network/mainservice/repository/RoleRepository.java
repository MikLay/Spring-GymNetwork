package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.user.ERoles;
import com.spp.gym_network.mainservice.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERoles role);
}
