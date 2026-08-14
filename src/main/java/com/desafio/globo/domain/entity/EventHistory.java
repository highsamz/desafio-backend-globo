package com.desafio.globo.domain.entity;

import com.desafio.globo.domain.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "event_history")
public class EventHistory {

    @Id
    private String id;
    private NotificationType type;
    private String subscriptionId;
    private LocalDateTime createdAt;

    public EventHistory(NotificationType type, String subscriptionId){
        this.type = type;
        this.subscriptionId = subscriptionId;
        this.createdAt = LocalDateTime.now();
    }
}
