package com.sit.cov.hackatron.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;

public interface ReservedTimeslotsRepository extends MongoRepository<ReservedTimeSlots, String> {

}
