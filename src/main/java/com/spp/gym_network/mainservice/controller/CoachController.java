package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.CoachDTO;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.mappers.CoachMapper;
import com.spp.gym_network.mainservice.dto.specifications.CoachSpec;
import com.spp.gym_network.mainservice.service.CoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CoachController {

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private CoachService coachService;


    @JsonView(JsonViews.Summary.class)
    @GetMapping("/coaches")
    public ResponseEntity<Page<CoachDTO>> findAll(CoachSpec spec, Pageable page) {
        return ResponseEntity.ok(coachService.findAll(spec, page).map(coachMapper::toDto));
    }

}
