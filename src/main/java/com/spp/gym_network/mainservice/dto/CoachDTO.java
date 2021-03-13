package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.model.coach.ESportRang;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonView(JsonViews.Summary.class)
@EqualsAndHashCode(callSuper = true)
@Data
public class CoachDTO extends UserDTO {

    private Long payment;

    private ESportRang rang;
}
