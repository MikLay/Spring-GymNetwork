package com.spp.gym_network.mainservice.dto;

import com.spp.gym_network.mainservice.model.user.ESex;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
public class SignUpRequest implements Serializable {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotEmpty(message = "BirthDate can not be empty")
    private Timestamp birthDate;

    private String phoneNumber;

    private MultipartFile image;

    private ESex sex;

}

