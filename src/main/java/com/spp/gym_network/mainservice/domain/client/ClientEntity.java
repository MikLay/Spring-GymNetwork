package com.spp.gym_network.mainservice.domain.client;

import com.spp.gym_network.mainservice.domain.user.UserEntity;
import com.spp.gym_network.mainservice.domain.workout.WorkoutEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity extends UserEntity {
    @OneToMany(mappedBy = "client")
    private Set<SubscriptionEntity> subscriptions = new HashSet<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkoutEntity> workouts = new ArrayList<>();

}
