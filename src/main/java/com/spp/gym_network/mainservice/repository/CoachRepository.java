package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long> {
    Page<CoachEntity> findAll(Specification<CoachEntity> spec, Pageable page);
}
