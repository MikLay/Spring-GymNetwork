package com.spp.gym_network.mainservice.dto.specifications;

import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Join(path = "timetables", alias = "t")
@And({
        @Spec(path = "payment", spec = Like.class),
        @Spec(path = "rang", spec = Like.class),
        @Spec(path = "email", spec = Like.class),
})
@Or({
        @Spec(path = "t.gym.address.street", params = "gym_address", spec = Like.class),
        @Spec(path = "t.gym.address.country", params = "gym_address", spec = Like.class),
        @Spec(path = "t.gym.address.city", params = "gym_address", spec = Like.class),
        @Spec(path = "t.gym.address.house", params = "gym_address", spec = Like.class),
        @Spec(path = "t.gym.address.flat", params = "gym_address", spec = Like.class)
})
public interface CoachSpec extends UserSpec<CoachEntity> {
}
