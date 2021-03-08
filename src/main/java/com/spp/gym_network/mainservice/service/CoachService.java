package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.dto.specifications.CoachSpec;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoachService {
    Page<CoachEntity> findAll(CoachSpec spec, Pageable page);
}
