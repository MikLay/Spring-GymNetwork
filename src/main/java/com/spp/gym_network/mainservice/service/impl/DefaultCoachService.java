package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import com.spp.gym_network.mainservice.model.specification.CoachSpec;
import com.spp.gym_network.mainservice.repository.CoachRepository;
import com.spp.gym_network.mainservice.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultCoachService implements CoachService {
    @Autowired
    CoachRepository coachRepository;

    @Override
    public Page<CoachEntity> findAll(CoachSpec spec, Pageable page) {
        return coachRepository.findAll(spec, page);
    }
}
