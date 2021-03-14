package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.WorkoutDTO;
import com.spp.gym_network.mainservice.dto.mappers.WorkoutMapper;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.WorkoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutMapper workoutMapper;

    @Autowired
    private WorkoutService workoutService;

    @JsonView(JsonViews.Summary.class)
    @GetMapping
    @PreAuthorize("hasRole('ROLE_COACH')")
    public ResponseEntity<Page<WorkoutDTO>> getAllWorkouts(@AuthenticationPrincipal CustomUserDetails userDetails, Pageable page) {
        return ResponseEntity.ok(workoutService.findMyWorkouts(userDetails, page).map(workoutMapper::toDto));
    }
}
