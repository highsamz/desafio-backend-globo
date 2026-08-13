package com.desafio.globo.infra.persistence;

import com.desafio.globo.domain.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatusRepository extends MongoRepository<Status, Integer> {
}
