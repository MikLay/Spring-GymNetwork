package com.spp.gym_network.mainservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkoutUIDVerificationRequest {
    @NotBlank
    @NotNull
    private String uid;
}
