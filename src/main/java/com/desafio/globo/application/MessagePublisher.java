package com.desafio.globo.application;

import com.desafio.globo.domain.dto.RequestSubscriptionDto;

public interface MessagePublisher {
    void publish(RequestSubscriptionDto requestSubscriptionDto);
}
