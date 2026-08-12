package com.desafio.globo.domain.dto;

import com.desafio.globo.domain.enums.NotificationType;

public record RequestNotificationDto (
        String subscriptionId,
        NotificationType type
) {}
