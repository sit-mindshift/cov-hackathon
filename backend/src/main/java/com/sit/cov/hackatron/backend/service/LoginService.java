package com.sit.cov.hackatron.backend.service;

import java.util.Optional;

import com.sit.cov.hackatron.backend.dto.LoginDTO;
import com.sit.cov.hackatron.backend.model.Customer;
import com.sit.cov.hackatron.backend.repository.CustomerRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

	public boolean login(LoginDTO dto) {
        Optional<Customer> customer = customerRepository.findByUsername(dto.getUsername());
        boolean isValid = false;
        if(customer.isPresent()) {
            isValid = customer.get().getPassword().equals(passwordEncoder.encode(dto.getPassword()));
        }
        return isValid;
	}

}
