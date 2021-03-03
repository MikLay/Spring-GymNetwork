package com.spp.gym_network.mainservice.domain.gym;

import com.spp.gym_network.mainservice.domain.Address;
import com.spp.gym_network.mainservice.domain.coach.TimetableEntity;
import com.spp.gym_network.mainservice.domain.manager.ManagerEntity;
import com.spp.gym_network.mainservice.domain.workout.WorkoutEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "gyms")
public class GymEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String email;

    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "gyms")
    private List<ManagerEntity> managers = new ArrayList<>();

    @OneToMany(
            mappedBy = "gym",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TimetableEntity> timetables = new ArrayList<>();

    @OneToMany(
            mappedBy = "gym",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EquipmentEntity> equipment = new ArrayList<>();

    @OneToMany(
            mappedBy = "gym",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkoutEntity> workouts = new ArrayList<>();


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GymEntity that = (GymEntity) o;
        return Objects.equals(id, that.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
