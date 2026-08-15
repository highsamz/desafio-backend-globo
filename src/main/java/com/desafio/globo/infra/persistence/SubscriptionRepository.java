package com.desafio.globo.infra.persistence;

import com.desafio.globo.domain.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    Optional<Subscription> findBySubscriptionId(String subscriptionId);
}
