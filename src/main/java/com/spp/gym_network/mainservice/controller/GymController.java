package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.ApiResponse;
import com.spp.gym_network.mainservice.dto.GymDTO;
import com.spp.gym_network.mainservice.dto.GymStatisticDTO;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.mappers.GymMapper;
import com.spp.gym_network.mainservice.dto.specifications.GymSpec;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.GymService;
import com.spp.gym_network.mainservice.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class GymController {

    @Autowired
    private GymMapper gymMapper;
    @Autowired
    private GymService gymService;
    @Autowired
    private ManagerService managerService;


    @JsonView(JsonViews.Summary.class)
    @GetMapping("/gyms")
    public ResponseEntity<Page<GymDTO>> findAll(GymSpec spec, Pageable page) {
        return ResponseEntity.ok(gymService.findAll(spec, page).map(gymMapper::toDto));
    }


    @JsonView(JsonViews.Detailed.class)
    @PreAuthorize(" hasRole('ROLE_MANAGER')")
    @GetMapping("/gyms/{id}/stats")
    public ResponseEntity<GymStatisticDTO> getGymStatistic(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable("id") String id) {
        if (managerService.isAllowedToManage(userDetails.getId(), Long.parseLong(id))) {
            return ResponseEntity.ok(gymService.getGymStatistic(Long.parseLong(id)));
        }
        return new ResponseEntity(new ApiResponse(false, "You are now allowed to manage this gym"), HttpStatus.FORBIDDEN);
    }


    @JsonView(JsonViews.Summary.class)
    @GetMapping("/gyms/{id}")
    public ResponseEntity<GymDTO> getGym(@PathVariable("id") String id) {
        return ResponseEntity.ok(gymMapper.toDto(gymService.findById(Long.parseLong(id))));
    }
}
