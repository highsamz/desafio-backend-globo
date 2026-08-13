package com.desafio.globo.domain.entity;

import com.desafio.globo.domain.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "subscription")
public class Subscription {

    @Id
    private Long id;
    private String subscription;
    private NotificationType notificationType;
}
