package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.dto.GymStatisticDTO;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.model.specification.GymSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GymService {
    Page<GymEntity> findAll(GymSpec gymSpec, Pageable page);

    GymEntity findById(Long id);

    GymStatisticDTO getGymStatistic(Long gymId);
}
