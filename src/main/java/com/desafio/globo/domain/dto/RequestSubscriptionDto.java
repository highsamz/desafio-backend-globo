package com.desafio.globo.domain.dto;

import com.desafio.globo.domain.enums.NotificationType;

public record RequestSubscriptionDto(
        String subscription,
        NotificationType notificationType
) {}
