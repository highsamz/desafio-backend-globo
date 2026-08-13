package com.desafio.globo.infra.persistence;

import com.desafio.globo.domain.entity.EventHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventHistoryRepository extends MongoRepository<EventHistory, Integer> {
}
