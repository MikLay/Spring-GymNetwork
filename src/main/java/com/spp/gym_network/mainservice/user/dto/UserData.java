package com.spp.gym_network.mainservice.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserData implements Serializable {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotEmpty(message = "Authority can`t be empty")
    private List<String> roles;
}

