package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {
    Page<WorkoutEntity> findAllByClient_Id(Long clientId, Pageable page);

    Page<WorkoutEntity> findAllByCoach_Id(Long coachId, Pageable page);
}
