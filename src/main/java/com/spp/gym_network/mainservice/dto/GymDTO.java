package com.spp.gym_network.mainservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GymDTO {
    private Long id;

    private String phone;

    private String email;

    private AddressDTO address;

    private List<EquipmentDTO> equipment;

}
