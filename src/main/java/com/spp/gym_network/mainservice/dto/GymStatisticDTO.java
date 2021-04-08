package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;

@JsonView(JsonViews.Summary.class)
@Data
public class GymStatisticDTO {
    private GymDTO gym;

    // Number of coaches
    private int coachesNum;

    // The most popular coach
    private CoachDTO topCoach;

    // The most popular coach for current month
    private CoachDTO topMonthCoach;

    // Number of workouts in current month
    private int workoutsMonthNum;

    // Number of workouts at all
    private int workoutsNum;

    // Number of workouts with coaches in current month
    private int workoutsFullNum;

    private List<CoachDTO> coaches;
    private List<ClientDTO> clients;
    private List<WorkoutDTO> workouts;

}
