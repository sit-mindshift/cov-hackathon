package com.sit.cov.hackatron.backend.controller;

import com.sit.cov.hackatron.backend.model.Customer;
import com.sit.cov.hackatron.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping(value = "/users")
    public Map<String, Object> getAllCustomers() {

        List<Customer> customers =  customerRepository.findAll();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("customers", customers);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");

        return responseMap;
    }
}
