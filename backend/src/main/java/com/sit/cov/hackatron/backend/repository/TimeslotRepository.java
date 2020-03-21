package com.sit.cov.hackatron.backend.repository;

import com.sit.cov.hackatron.backend.model.Timeslot;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TimeslotRepository extends MongoRepository<Timeslot, String> {

}
