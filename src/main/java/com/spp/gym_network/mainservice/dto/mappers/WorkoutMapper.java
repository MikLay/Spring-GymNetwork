package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.WorkoutDTO;
import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {
    WorkoutDTO toDto(WorkoutEntity workoutEntity, @Context CycleAvoidingMappingContext context);
}
