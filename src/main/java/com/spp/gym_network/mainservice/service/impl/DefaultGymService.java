package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.dto.specifications.GymSpec;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.repository.GymRepository;
import com.spp.gym_network.mainservice.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DefaultGymService implements GymService {

    @Autowired
    GymRepository repository;

    @Override
    public Page<GymEntity> findAll(GymSpec gymSpec, Pageable page) {
        return repository.findAll(gymSpec, page);
    }
}
