package com.desafio.globo.config;

import com.desafio.globo.infra.messaging.properties.SubscriptionQueueProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class RabbitMqConfiguration {
    private final SubscriptionQueueProperties subscriptionQueueProperties;

    @Bean
    public Queue queue(){
        log.info("Looking for queue: {}", subscriptionQueueProperties.getName());
        return new Queue(subscriptionQueueProperties.getName(), true);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
