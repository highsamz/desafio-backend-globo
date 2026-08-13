package com.desafio.globo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "event_history")
@Getter
@Setter
@AllArgsConstructor
public class EventHistory {

    @Id
    private Integer id;
    private String type;
    private String subscriptionId;
    private LocalDateTime createdAt;
}
