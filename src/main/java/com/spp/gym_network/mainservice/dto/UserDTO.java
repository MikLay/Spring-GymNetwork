package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.model.user.ESex;
import lombok.Data;

import java.sql.Timestamp;

@JsonView(JsonViews.Summary.class)
@Data
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private ESex sex;

    private String email;

    @JsonView(JsonViews.Detailed.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp birthDate;

    @JsonView(JsonViews.Detailed.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp registrationDate;

    @JsonView(JsonViews.Detailed.class)
    private String phoneNumber;

    private String avatar;

}
