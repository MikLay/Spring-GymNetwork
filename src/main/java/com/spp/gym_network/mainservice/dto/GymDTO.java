package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;

@JsonView(JsonViews.Summary.class)
@Data
public class GymDTO {
    private Long id;

    private String phone;

    private String email;

    private Long fine;

    @JsonUnwrapped
    private AddressDTO address;


    @JsonView(JsonViews.Detailed.class)
    private List<EquipmentDTO> equipment;

}
