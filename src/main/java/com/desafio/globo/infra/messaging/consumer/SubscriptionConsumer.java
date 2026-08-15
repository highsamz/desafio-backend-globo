package com.desafio.globo.infra.messaging.consumer;

import com.desafio.globo.api.request.RequestSubscriptionDto;
import com.desafio.globo.application.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptionConsumer {

    SubscriptionService subscriptionService;
    public SubscriptionConsumer(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @RabbitListener(queues = "${broker.queue.subscription.name}")
    public void listenEmailQueue(@Payload RequestSubscriptionDto requestSubscriptionDto){
        log.info("Received: {}", requestSubscriptionDto);
        subscriptionService.process(requestSubscriptionDto);
    }
}
