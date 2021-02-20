package com.spp.gym_network.mainservice.controller;

import com.spp.gym_network.mainservice.exception.InvalidTokenException;
import com.spp.gym_network.mainservice.exception.UserAlreadyExistException;
import com.spp.gym_network.mainservice.user.dto.UserData;
import com.spp.gym_network.mainservice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String userRegistration(@RequestBody @Valid UserData userData, final BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "NG!";
        }
        try {
            userService.register(userData);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            return "ar";
        }
        return "OK!";
    }

    @GetMapping("verify")
    public String verifyCustomer(@RequestParam(required = false) String token){
        if(StringUtils.isEmpty(token)){
            return "Missing token!";
        }
        try {
            userService.verifyUser(token);
        } catch (InvalidTokenException e) {
            return "Invalid token!";
        }

        return "successfully verified";
    }

}
