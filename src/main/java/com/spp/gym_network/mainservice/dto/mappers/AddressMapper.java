package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.AddressDTO;
import com.spp.gym_network.mainservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDto(Address address);
}
