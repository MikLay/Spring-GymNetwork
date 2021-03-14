package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.ApiResponse;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.TimetableDTO;
import com.spp.gym_network.mainservice.dto.mappers.TimetableMapper;
import com.spp.gym_network.mainservice.dto.requests.TimetableCreateRequest;
import com.spp.gym_network.mainservice.exception.BadRequestException;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.TimetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/timetables")
public class TimetableController {

    @Autowired
    private TimetableMapper timetableMapper;

    @Autowired
    private TimetableService timetableService;


    @JsonView(JsonViews.Summary.class)
    @GetMapping
    @PreAuthorize("hasRole('ROLE_COACH')")
    public ResponseEntity<Page<TimetableDTO>> getTimetables(@AuthenticationPrincipal CustomUserDetails userDetails, Pageable page) {
        return ResponseEntity.ok(timetableService.findMyTimetables(userDetails.getId(), page).map(timetableMapper::toDto));
    }

    @JsonView(JsonViews.Summary.class)
    @PostMapping
    @PreAuthorize("hasRole('ROLE_COACH')")
    public ResponseEntity<TimetableDTO> createTimetable(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                        final @Valid @RequestBody TimetableCreateRequest timetable) {
        try {
            TimetableDTO timetableDTO = timetableMapper
                    .toDto(timetableService.createTimetable(
                            userDetails.getId(),
                            timetable.getGymId(),
                            timetable.getStartTime(),
                            timetable.getEndTime()));
            return ResponseEntity.ok(timetableDTO);
        } catch (BadRequestException e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
