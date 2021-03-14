package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.model.user.ERoles;
import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import com.spp.gym_network.mainservice.repository.WorkoutRepository;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.WorkoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DefaultWorkoutService implements WorkoutService {
    @Autowired
    WorkoutRepository workoutRepository;

    @Override
    public Page<WorkoutEntity> findMyWorkouts(CustomUserDetails user, Pageable page) {
        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        if (roles.contains(ERoles.ROLE_CLIENT.name())) {
            return workoutRepository.findAllByClient_Id(user.getId(), page);
        } else if (roles.contains(ERoles.ROLE_COACH.name())) {
            return workoutRepository.findAllByCoach_Id(user.getId(), page);
        } else {
            //TODO: Add manager variant
            return null;
        }
    }
}
