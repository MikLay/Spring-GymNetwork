package com.spp.gym_network.mainservice.model.specification;

import com.spp.gym_network.mainservice.model.user.UserEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "firsName", spec = Like.class),
        @Spec(path = "lastName", spec = Like.class),
        @Spec(path = "birthDate", params = {"birthDateAfter", "birthDateBefore"},
                spec = Between.class),
        @Spec(path = "email", spec = Like.class),
        @Spec(path = "sex", spec = Like.class),
})
public interface UserSpec<T extends UserEntity> extends Specification<T> {
}
