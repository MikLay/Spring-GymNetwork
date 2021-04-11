package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.dto.GymStatisticDTO;
import com.spp.gym_network.mainservice.exception.EntityNotFoundException;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.model.specification.GymSpec;
import com.spp.gym_network.mainservice.repository.GymRepository;
import com.spp.gym_network.mainservice.repository.ManagerRepository;
import com.spp.gym_network.mainservice.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DefaultGymService implements GymService {

    @Autowired
    GymRepository repository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Page<GymEntity> findAll(GymSpec gymSpec, Pageable page) {
        return repository.findAll(gymSpec, page);
    }

    @Override
    public GymEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gym not found with id: " + id));
    }

    @Override
    public GymStatisticDTO getGymStatistic(Long gymId) {
        //TODO: add statistic
        return null;
    }
}
