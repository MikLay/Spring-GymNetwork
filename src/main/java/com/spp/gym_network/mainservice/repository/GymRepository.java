package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.gym.GymEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GymRepository extends JpaRepository<GymEntity, Long> {
    Page<GymEntity> findAll(Specification<GymEntity> spec, Pageable page);
}
