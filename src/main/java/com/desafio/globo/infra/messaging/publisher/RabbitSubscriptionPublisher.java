package com.desafio.globo.infra.messaging.publisher;

import com.desafio.globo.application.MessagePublisher;
import com.desafio.globo.api.request.RequestSubscriptionDto;
import com.desafio.globo.infra.messaging.properties.SubscriptionQueueProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitSubscriptionPublisher implements MessagePublisher {
    private final SubscriptionQueueProperties subscriptionQueueProperties;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(RequestSubscriptionDto requestSubscriptionDto) {
        log.info("Notifying queue: {} of text{}", subscriptionQueueProperties.getName(), requestSubscriptionDto);
        rabbitTemplate.convertAndSend(subscriptionQueueProperties.getName(),requestSubscriptionDto);
    }
}
