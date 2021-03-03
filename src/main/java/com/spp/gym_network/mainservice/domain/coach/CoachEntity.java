package com.spp.gym_network.mainservice.domain.coach;

import com.spp.gym_network.mainservice.domain.Address;
import com.spp.gym_network.mainservice.domain.user.ESportRang;
import com.spp.gym_network.mainservice.domain.user.UserEntity;
import com.spp.gym_network.mainservice.domain.workout.WorkoutEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "coaches")
public class CoachEntity extends UserEntity {
    private Long payment;

    @Enumerated(EnumType.STRING)
    private ESportRang rang;

    @Embedded
    private Address address;

    @OneToMany(
            mappedBy = "coach",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TimetableEntity> timetables = new ArrayList<>();

    @OneToMany(
            mappedBy = "coach",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkoutEntity> workouts = new ArrayList<>();
}
