package com.desafio.globo.application;

import com.desafio.globo.api.request.RequestSubscriptionDto;

public interface MessagePublisher {
    void publish(RequestSubscriptionDto requestSubscriptionDto);
}
