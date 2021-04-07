package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.ClientDTO;
import com.spp.gym_network.mainservice.model.client.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper extends UserMapper{
    @Mapping(source = "image", target = "avatar", qualifiedByName = "encodeImage")
    ClientDTO toDto(ClientEntity client);
}
