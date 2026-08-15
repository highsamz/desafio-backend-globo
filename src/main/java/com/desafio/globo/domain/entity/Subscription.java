package com.desafio.globo.domain.entity;

import com.desafio.globo.domain.enums.SubscriptionStatus;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@Document(collection = "subscription")
public class Subscription {

    @Id
    private String subscriptionId;
    private SubscriptionStatus statusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Subscription(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        this.statusId = SubscriptionStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void activate() {
        this.statusId = SubscriptionStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        this.statusId = SubscriptionStatus.CANCELED;
        this.updatedAt = LocalDateTime.now();
    }

}
