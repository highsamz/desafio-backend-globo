package com.desafio.globo.api.request;

import com.desafio.globo.domain.enums.NotificationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestSubscriptionDto(
        @Schema(example = "usuario@email.com")
        @NotBlank String subscription,

        @Schema(example = "SUBSCRIPTION_PURCHASED")
        @NotNull NotificationType notificationType
) {}
