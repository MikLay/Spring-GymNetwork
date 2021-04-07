package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.GymDTO;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.mappers.GymMapper;
import com.spp.gym_network.mainservice.dto.specifications.GymSpec;
import com.spp.gym_network.mainservice.service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class GymController {

    @Autowired
    private GymMapper gymMapper;
    @Autowired
    private GymService gymService;


    @JsonView(JsonViews.Summary.class)
    @GetMapping("/gyms")
    public ResponseEntity<Page<GymDTO>> findAll(GymSpec spec, Pageable page) {
        return ResponseEntity.ok(gymService.findAll(spec, page).map(gymMapper::toDto));
    }
}
