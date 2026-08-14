package com.desafio.globo.application.service;

import com.desafio.globo.api.request.RequestSubscriptionDto;
import com.desafio.globo.domain.entity.EventHistory;
import com.desafio.globo.domain.entity.Subscription;
import com.desafio.globo.domain.exception.SubscriptionNotFoundException;
import com.desafio.globo.infra.persistence.EventHistoryRepository;
import com.desafio.globo.infra.persistence.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final EventHistoryRepository eventHistoryRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               EventHistoryRepository eventHistoryRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.eventHistoryRepository = eventHistoryRepository;
    }

    public void process (RequestSubscriptionDto requestSubscriptionDto) {
        var notificationType = requestSubscriptionDto.notificationType();
        var subscriptionId = requestSubscriptionDto.subscription();

        switch (notificationType) {
            case SUBSCRIPTION_PURCHASED -> {
                eventHistoryRepository.save(new EventHistory(notificationType, subscriptionId));

                subscriptionRepository.save(
                        new Subscription(subscriptionId));
            }

            case SUBSCRIPTION_RESTARTED -> {
                eventHistoryRepository.save(new EventHistory(notificationType, subscriptionId));

                Subscription subscription = subscriptionRepository
                        .findBySubscription(subscriptionId)
                        .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));

                subscription.activate();
                subscriptionRepository.save(subscription);
            }

            case SUBSCRIPTION_CANCELED -> {
                eventHistoryRepository.save(new EventHistory(notificationType, subscriptionId));

                Subscription subscription = subscriptionRepository
                        .findBySubscription(subscriptionId)
                        .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));

                subscription.cancel();
                subscriptionRepository.save(subscription);
            }
        }
    }
}
