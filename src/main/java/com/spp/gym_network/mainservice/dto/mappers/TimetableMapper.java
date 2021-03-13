package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.TimetableDTO;
import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GymMapper.class, CoachMapper.class})
public interface TimetableMapper {
    TimetableDTO toDto(TimetableEntity timetableEntity);
}
