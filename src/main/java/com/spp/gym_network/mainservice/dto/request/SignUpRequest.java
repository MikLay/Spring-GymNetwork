package com.spp.gym_network.mainservice.dto.request;

import com.spp.gym_network.mainservice.model.user.ESex;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class SignUpRequest {

    @NotNull(message = "First name can not be empty")
    private String firstName;

    @NotNull(message = "Last name can not be empty")
    private String lastName;

    @NotNull(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotNull(message = "Password can not be empty")
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Temporal(value = TemporalType.DATE)
    private LocalDate birthDate;

    private String phoneNumber;

    private MultipartFile image;

    @NotNull
    private ESex sex;

}

