package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@JsonView(JsonViews.Summary.class)
@Data
public class SubscriptionDTO {
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startingDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp expiringDatetime;


    @JsonFormat(pattern="HH:mm:ss")
    private Time beginningTime;


    @JsonFormat(pattern="HH:mm:ss")
    private Time endingTime;

    private Long price;

    private String uid;

}
