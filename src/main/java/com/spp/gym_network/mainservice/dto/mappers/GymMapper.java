package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.GymDTO;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/*
 Use componentModel parameter due to IntelliJ does not
 pick up the maven-compiler-plugin compiler arguments
*/
@Mapper(componentModel = "spring", uses = {AddressMapper.class, EquipmentMapper.class})
public interface GymMapper {
    GymMapper INSTANCE = Mappers.getMapper(GymMapper.class);

    GymDTO toDto(GymEntity gymEntity);

    GymEntity map(GymDTO gymDTO);
}
