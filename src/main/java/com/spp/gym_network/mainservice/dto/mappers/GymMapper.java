package com.spp.gym_network.mainservice.dto.mappers;

import com.spp.gym_network.mainservice.dto.GymDTO;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.charset.StandardCharsets;

/*
 Use componentModel parameter due to IntelliJ does not
 pick up the maven-compiler-plugin compiler arguments
*/
@Mapper(componentModel = "spring", uses = {AddressMapper.class, EquipmentMapper.class})
public interface GymMapper {
    GymMapper INSTANCE = Mappers.getMapper(GymMapper.class);

    @Mapping(source = "image", target = "avatar", qualifiedByName = "encodeImage")
    GymDTO toDto(GymEntity gymEntity);

    GymEntity map(GymDTO gymDTO);

    @Named("encodeImage")
    default String imageEncoding(byte[] image) {
        if (image == null) {
            return null;
        }
        byte[] encode = java.util.Base64.getEncoder().encode(image);
        return new String(encode, StandardCharsets.UTF_8);
    }
}
