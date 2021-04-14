package com.spp.gym_network.mainservice.controller;

import com.spp.gym_network.mainservice.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class ClientController {

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Boolean> verifyWorkout(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                 final @Valid @RequestBody String UID) {
        log.warn(UID);
        return ResponseEntity.ok(true);

    }
}
