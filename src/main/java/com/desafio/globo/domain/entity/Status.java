package com.desafio.globo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "status")
@Getter
@Setter
@AllArgsConstructor
public class Status {

    @Id
    private Integer id;
    private String name;

}