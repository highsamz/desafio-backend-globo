package com.desafio.globo.infra.messaging.consumer;

import com.desafio.globo.domain.dto.RequestSubscriptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptionConsumer {
    @RabbitListener(queues = "${broker.queue.subscription.name}")
    public void listenEmailQueue(@Payload RequestSubscriptionDto requestSubscriptionDto){
        log.info("Received: {}", requestSubscriptionDto);
    }
}
