package com.desafio.globo.application.service;

import com.desafio.globo.infra.persistence.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    SubscriptionRepository subscriptionRepository;
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

}
