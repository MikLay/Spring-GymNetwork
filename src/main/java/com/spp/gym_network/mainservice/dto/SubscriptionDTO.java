package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.sql.Timestamp;

@JsonView(JsonViews.Summary.class)
@Data
public class SubscriptionDTO {
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;

    private Long price;

}
