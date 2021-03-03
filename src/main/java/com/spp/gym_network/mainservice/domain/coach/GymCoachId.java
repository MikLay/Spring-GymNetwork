package com.spp.gym_network.mainservice.domain.coach;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class GymCoachId
        implements Serializable {

    private Long gymId;

    private Long coachId;

}
