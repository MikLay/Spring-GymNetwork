package com.spp.gym_network.mainservice.model.coach;

import com.spp.gym_network.mainservice.model.Address;
import com.spp.gym_network.mainservice.model.user.UserEntity;
import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
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
