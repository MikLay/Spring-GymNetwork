package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkoutService {
    Page<WorkoutEntity> findMyWorkouts(CustomUserDetails user, Pageable page);

}
