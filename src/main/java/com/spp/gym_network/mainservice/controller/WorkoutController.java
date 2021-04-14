package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.WorkoutDTO;
import com.spp.gym_network.mainservice.dto.mappers.WorkoutMapper;
import com.spp.gym_network.mainservice.dto.request.WorkoutCreateRequest;
import com.spp.gym_network.mainservice.dto.request.WorkoutUIDVerificationRequest;
import com.spp.gym_network.mainservice.model.specification.WorkoutSpec;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.WorkoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    @PreAuthorize("hasRole('ROLE_COACH') or hasRole('ROLE_CLIENT') or hasRole('ROLE_MANAGER')")
    public ResponseEntity<Page<WorkoutDTO>> getAllWorkouts(@AuthenticationPrincipal CustomUserDetails userDetails, WorkoutSpec spec, Pageable page) {
        return ResponseEntity.ok(workoutService.findMyWorkouts(userDetails, spec, page).map(workoutMapper::toDto));
    }

    @JsonView(JsonViews.Summary.class)
    @PostMapping
    @PreAuthorize(" hasRole('ROLE_CLIENT')")
    public ResponseEntity<WorkoutDTO> createWorkout(@AuthenticationPrincipal CustomUserDetails userDetails, final @Valid @RequestBody WorkoutCreateRequest workout) {
        WorkoutDTO workoutDTO = workoutMapper.toDto(workoutService.createWorkout(
                userDetails.getId(),
                workout.getCoachId(),
                workout.getGymId(),
                workout.getStartTime(),
                workout.getEndTime()
        ));
        return ResponseEntity.ok(workoutDTO);
    }

    @PostMapping("/{id}/verify")
    @PreAuthorize(" hasRole('ROLE_MANAGER')")
    public ResponseEntity<Boolean> verifyWorkout(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable("id") String id) {
        return ResponseEntity.ok(workoutService.verifyWorkout(userDetails.getId(), Long.parseLong(id)));
    }

    @PostMapping("/uid-verification")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Boolean> verifyWorkoutByClientUID(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                            final @Valid @RequestBody WorkoutUIDVerificationRequest workoutVerificationRequest) {
        return ResponseEntity.ok(workoutService.verifyWorkout(userDetails.getId(), workoutVerificationRequest));

    }
}
