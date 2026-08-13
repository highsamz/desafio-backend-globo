package com.desafio.globo.infra.messaging.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("broker.queue.subscription")
@Component
@Getter
@Setter
public class SubscriptionQueueProperties {
    private String name;
}
