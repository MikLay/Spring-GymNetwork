package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
    Page<TimetableEntity> findAllByCoach_Id(Long coach_id, Pageable pageable);
}
