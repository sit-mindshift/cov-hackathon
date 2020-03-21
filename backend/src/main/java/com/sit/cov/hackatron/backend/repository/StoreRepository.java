package com.sit.cov.hackatron.backend.repository;

import com.sit.cov.hackatron.backend.model.DBStore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<DBStore, Long> {
}
