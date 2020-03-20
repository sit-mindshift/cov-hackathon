package com.sit.cov.hackatron.backend.repository;

import com.sit.cov.hackatron.backend.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

}
