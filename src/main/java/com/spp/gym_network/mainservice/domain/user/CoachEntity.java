package com.spp.gym_network.mainservice.domain.user;

import com.spp.gym_network.mainservice.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="coaches")
public class CoachEntity extends UserEntity {
    private Long payment;

    @Enumerated(EnumType.STRING)
    private ESportRang rang;

    @Embedded
    private Address address;
}
