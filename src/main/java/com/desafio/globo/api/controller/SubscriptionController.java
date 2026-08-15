package com.desafio.globo.api.controller;

import com.desafio.globo.api.request.RequestSubscriptionDto;
import com.desafio.globo.infra.messaging.publisher.RabbitSubscriptionPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final RabbitSubscriptionPublisher publisher;

    public SubscriptionController(RabbitSubscriptionPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void processSubscription(@RequestBody RequestSubscriptionDto requestSubscriptionDto) {
        publisher.publish(requestSubscriptionDto);
    }
}
