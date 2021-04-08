package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.repository.ManagerRepository;
import com.spp.gym_network.mainservice.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultManagerServiceI implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Boolean isAllowedToManage(Long managerId, Long gymId) {
        return managerRepository.existsByIdAndGyms_Id(managerId, gymId);
    }
}
