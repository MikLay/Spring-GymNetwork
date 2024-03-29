package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.dto.request.WorkoutUIDVerificationRequest;
import com.spp.gym_network.mainservice.model.specification.WorkoutSpec;
import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;

public interface WorkoutService {
    Page<WorkoutEntity> findMyWorkouts(CustomUserDetails user, WorkoutSpec spec, Pageable page);

    WorkoutEntity createWorkout(Long clientId, Long coachId, Long gymId, Timestamp startTime, Timestamp endTime);

    Boolean verifyWorkout(Long managerId, Long workoutId);

    Boolean verifyWorkout(Long managerId, WorkoutUIDVerificationRequest workoutUID);
}
