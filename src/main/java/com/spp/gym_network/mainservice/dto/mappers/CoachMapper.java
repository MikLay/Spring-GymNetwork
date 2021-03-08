package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.CoachDTO;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoachMapper extends UserMapper {
    CoachDTO toDto(CoachEntity coachEntity);
}
