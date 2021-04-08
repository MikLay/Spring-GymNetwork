package com.spp.gym_network.mainservice.service;

public interface ManagerService {
    Boolean isAllowedToManage(Long managerId, Long gymId);
}
