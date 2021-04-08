package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.manager.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Long> {
    Boolean existsByIdAndGyms_Id(final Long managerId, final Long gymId);
}

