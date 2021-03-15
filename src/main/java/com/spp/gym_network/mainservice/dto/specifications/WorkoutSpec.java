package com.spp.gym_network.mainservice.dto.specifications;

import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import net.kaczmarzyk.spring.data.jpa.domain.DateBetween;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "id", spec = Like.class),
        @Spec(
                path = "startTime",
                params = {"startAfter", "startBefore"},
                spec = DateBetween.class
        ),
        @Spec(
                path = "endTime",
                params = {"endAfter", "endBefore"},
                spec = DateBetween.class
        ),
        @Spec(path = "gym.id", params = "gym_id", spec = Like.class),
        @Spec(path = "gym.address.city", params = "city", spec = Like.class),
        @Spec(path = "gym.address.country", params = "country", spec = Like.class),
        @Spec(path = "gym.address.flat", params = "flat", spec = Like.class),
        @Spec(path = "gym.address.street", params = "street", spec = Like.class),
})
@Conjunction({
        @Or({
                @Spec(path = "coach.firstname", params = "coach_name", spec = Like.class),
                @Spec(path = "coach.lastname", params = "coach_name", spec = Like.class)}),
        @Or({
                @Spec(path = "client.firstname", params = "client_name", spec = Like.class),
                @Spec(path = "client.lastname", params = "client_name", spec = Like.class)}),
        @Or({
                @Spec(path = "coach.firstname", params = "coach_name", spec = Like.class),
                @Spec(path = "coach.lastname", params = "coach_name", spec = Like.class)}),
})

public interface WorkoutSpec extends Specification<WorkoutEntity> {
}
