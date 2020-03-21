package com.sit.cov.hackatron.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;


public interface ReservedTimeslotRepository extends MongoRepository<ReservedTimeSlots, String> {

}
