package com.spp.gym_network.mainservice.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
}
