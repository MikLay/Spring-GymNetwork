package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@JsonView(JsonViews.Summary.class)
@Data
public class EquipmentDTO {
    private Long id;

    private String name;

    private String type;

    private String equipmentCondition;

    private String imageUrl;
}
