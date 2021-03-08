package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.UserDTO;
import com.spp.gym_network.mainservice.model.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(UserEntity userEntity);
}
