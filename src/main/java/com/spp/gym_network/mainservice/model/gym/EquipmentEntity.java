package com.spp.gym_network.mainservice.model.gym;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "equipment")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String equipmentCondition;

    @Column(name = "image_url")
    private String imageUrl;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private GymEntity gym;
}
