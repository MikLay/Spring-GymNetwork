package com.spp.gym_network.mainservice.model.workout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spp.gym_network.mainservice.model.client.ClientEntity;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "workouts")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private CoachEntity coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private GymEntity gym;

    private Long surcharge = 0L;

    public Long addSurcharge(Long amount) {
        return surcharge += amount;
    }
}
