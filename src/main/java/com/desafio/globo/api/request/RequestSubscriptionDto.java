package com.desafio.globo.api.request;

import com.desafio.globo.domain.enums.NotificationType;

public record RequestSubscriptionDto(
        String subscription,
        NotificationType notificationType
) {}
