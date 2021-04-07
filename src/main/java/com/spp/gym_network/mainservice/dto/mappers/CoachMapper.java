package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.CoachDTO;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoachMapper extends UserMapper {
    @Mapping(source = "image", target = "avatar", qualifiedByName = "encodeImage")
    CoachDTO toDto(CoachEntity coachEntity);
}
