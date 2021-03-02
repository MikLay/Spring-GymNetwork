package com.spp.gym_network.mainservice.domain.gym;

import com.spp.gym_network.mainservice.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="gyms")
public class GymEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "gym")
    private Set<EquipmentEntity> equipment;
}
