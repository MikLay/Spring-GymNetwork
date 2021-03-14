package com.spp.gym_network.mainservice.dto.specifications;

import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import net.kaczmarzyk.spring.data.jpa.domain.DateBetween;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "coach.id", spec= Like.class),
        @Spec(path = "coach.payment", spec=Like.class),
        @Spec(path = "gym.address", spec=Like.class),
        @Spec(path = "gym.email", spec=Like.class),
        @Spec(
                path = "startTime",
                params = { "startAfter", "startBefore" },
                spec = DateBetween.class
        ),
        @Spec(
                path = "endTime",
                params = { "endAfter", "endBefore" },
                spec = DateBetween.class
        )
})
public interface TimetableSpec extends Specification<TimetableEntity> {
}