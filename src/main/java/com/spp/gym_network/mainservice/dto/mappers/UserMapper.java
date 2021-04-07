package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.UserDTO;
import com.spp.gym_network.mainservice.model.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.nio.charset.StandardCharsets;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "image", target = "avatar", qualifiedByName = "encodeImage")
    UserDTO toDto(UserEntity userEntity);

    @Named("encodeImage")
    default String imageEncoding(byte[] image) {
        byte[] encode = java.util.Base64.getEncoder().encode(image);
        return new String(encode, StandardCharsets.UTF_8);
    }
}
