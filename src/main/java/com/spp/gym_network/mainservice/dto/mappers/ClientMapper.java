package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.ClientDTO;
import com.spp.gym_network.mainservice.model.client.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends UserMapper{
    ClientDTO toDto(ClientEntity client);
}
