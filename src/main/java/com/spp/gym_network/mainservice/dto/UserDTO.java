package com.spp.gym_network.mainservice.dto;

import com.spp.gym_network.mainservice.model.user.ESex;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private ESex sex;

    private String email;

}
