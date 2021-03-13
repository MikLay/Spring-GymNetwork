package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@JsonView(JsonViews.Summary.class)
@Data
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
}
