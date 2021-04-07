package com.spp.gym_network.mainservice.dto.specifications;

import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.*;

@Join(path = "timetables", alias = "t")
@And({
        @Spec(path = "payment", spec = Like.class),
        @Spec(path = "rang", spec = Like.class),
        @Spec(path = "email", spec = Like.class),
        @Spec(path = "t.gym.id", params = "gym_id", spec = Equal.class),
        @Spec(
                path = "t.startTime",
                params = "start_time",
                spec = LessThanOrEqual.class,
                config = "yyyy-MM-dd HH:mm:ss"
        ),
        @Spec(
                path = "t.endTime",
                params = "end_time",
                spec = GreaterThanOrEqual.class,
                config = "yyyy-MM-dd HH:mm:ss"
        ),
})
@Conjunction({
        @Or({
                @Spec(path = "t.gym.address.street", params = "gym_address", spec = Like.class),
                @Spec(path = "t.gym.address.country", params = "gym_address", spec = Like.class),
                @Spec(path = "t.gym.address.city", params = "gym_address", spec = Like.class),
                @Spec(path = "t.gym.address.house", params = "gym_address", spec = Like.class),
                @Spec(path = "t.gym.address.flat", params = "gym_address", spec = Like.class)}),

})
public interface CoachSpec extends UserSpec<CoachEntity> {
}
