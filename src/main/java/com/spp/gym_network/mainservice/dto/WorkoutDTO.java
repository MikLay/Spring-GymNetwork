package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.sql.Timestamp;

@JsonView(JsonViews.Summary.class)
@Data
public class WorkoutDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;

    private CoachDTO coach;

    private GymDTO gym;

    private CoachDTO client;

    private int surcharge;

}
