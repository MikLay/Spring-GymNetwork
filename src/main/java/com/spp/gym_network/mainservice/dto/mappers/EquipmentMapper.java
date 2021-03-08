package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.EquipmentDTO;
import com.spp.gym_network.mainservice.model.gym.EquipmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    EquipmentDTO toDto(EquipmentEntity equipment);
}
