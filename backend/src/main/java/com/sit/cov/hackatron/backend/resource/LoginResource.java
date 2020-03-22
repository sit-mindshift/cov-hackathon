package com.sit.cov.hackatron.backend.resource;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sit.cov.hackatron.backend.dto.LoginDTO;
import com.sit.cov.hackatron.backend.repository.CustomerRepository;
import com.sit.cov.hackatron.backend.service.LoginService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(LoginResource.LOGIN_ENDPOINT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginResource {

    public static final String LOGIN_ENDPOINT = "/login-api";
    private final LoginService loginService;
    private final CustomerRepository customerRepository;

    @PostMapping
    @ResponseBody
    public Map<String, Object> login(@RequestBody LoginDTO dto, HttpServletResponse response) {

        boolean userIsLoggedIn = loginService.login(dto);
        Map<String, Object> responseMap = new HashMap<>();
        
        if(userIsLoggedIn) {
            responseMap.put("customer", customerRepository.findByUsername(dto.getUsername()));
            responseMap.put("status", 200);
            responseMap.put("message", "Success");
        } else {
            responseMap.put("status", 400);
            responseMap.put("message", "Error");
        }

        return responseMap;
    }
}