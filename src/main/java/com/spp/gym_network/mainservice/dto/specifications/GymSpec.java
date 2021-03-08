package com.spp.gym_network.mainservice.dto.specifications;

import com.spp.gym_network.mainservice.model.gym.GymEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "address.city", params = "address", spec = Like.class),
        @Spec(path = "address.country", params = "address", spec = Like.class),
        @Spec(path = "address.flat", params = "address", spec = Like.class),
        @Spec(path = "address.street", params = "address", spec = Like.class),
        @Spec(path = "email", spec = Like.class),
        @Spec(path = "phone", spec = Like.class),
})
public interface GymSpec extends Specification<GymEntity> {
}
