package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.model.user.ESex;
import lombok.Data;

@JsonView(JsonViews.Summary.class)
@Data
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private ESex sex;

    private String email;

}
