package com.spp.gym_network.mainservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
}