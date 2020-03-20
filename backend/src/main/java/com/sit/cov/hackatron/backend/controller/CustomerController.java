package com.sit.cov.hackatron.backend.controller;

import com.sit.cov.hackatron.backend.model.Customer;
import com.sit.cov.hackatron.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping(value = "/customers")
    public Map<String, Object> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("customers", customers);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");

        return responseMap;
    }


    @GetMapping(value = "/customer/{id}")
    public Map<String, Object> findUser(@PathVariable String id) {

        Optional<Customer> customer = customerRepository.findById(Long.parseLong(id));
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("customer", customer);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");
        return responseMap;
    }

    @PostMapping(value = "/customer")
    public Map<String, Object> saveUser(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("customer", savedCustomer);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");
        return responseMap;
    }

}
