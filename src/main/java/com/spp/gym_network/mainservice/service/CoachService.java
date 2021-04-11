package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import com.spp.gym_network.mainservice.model.specification.CoachSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoachService {
    Page<CoachEntity> findAll(CoachSpec spec, Pageable page);
}
