package com.spp.gym_network.mainservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@JsonView(JsonViews.Summary.class)
@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDTO extends UserDTO {
    private List<SubscriptionDTO> subscriptions;
}
