package com.spp.gym_network.mainservice.repository;

import com.spp.gym_network.mainservice.model.client.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    Optional<SubscriptionEntity> findFirstByUid(String uid);
}
