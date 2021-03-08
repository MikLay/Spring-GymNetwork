package com.spp.gym_network.mainservice.model.manager;

import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.model.user.UserEntity;
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
@Table(name="manager")
public class ManagerEntity extends UserEntity {
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "manager_gym",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    private List<GymEntity> gyms = new ArrayList<>();
}
