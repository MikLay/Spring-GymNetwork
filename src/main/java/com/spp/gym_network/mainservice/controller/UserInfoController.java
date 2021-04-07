package com.spp.gym_network.mainservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spp.gym_network.mainservice.dto.JsonViews;
import com.spp.gym_network.mainservice.dto.UserDTO;
import com.spp.gym_network.mainservice.dto.mappers.UserMapper;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {

    @Qualifier("userMapperImpl")
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @JsonView(JsonViews.Detailed.class)
    @GetMapping("/me")
    public ResponseEntity<UserDTO> currentUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserInformation(userDetails.getId())));
    }
}
