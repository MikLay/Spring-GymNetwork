package com.spp.gym_network.mainservice.domain.gym;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "equipment")
@ToString
@EqualsAndHashCode
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String equipmentCondition;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private GymEntity gym;
}
