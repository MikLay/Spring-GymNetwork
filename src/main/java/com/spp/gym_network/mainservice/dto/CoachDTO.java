package com.spp.gym_network.mainservice.dto;

import com.spp.gym_network.mainservice.model.coach.ESportRang;
import lombok.Data;

@Data
public class CoachDTO extends UserDTO {
    private Long payment;

    private ESportRang rang;
}
