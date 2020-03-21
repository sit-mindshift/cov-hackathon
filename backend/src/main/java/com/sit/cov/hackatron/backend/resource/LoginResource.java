package com.sit.cov.hackatron.backend.resource;

import com.sit.cov.hackatron.backend.dto.LoginDTO;
import com.sit.cov.hackatron.backend.service.LoginService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(LoginResource.LOGIN_ENDPOINT)
public class LoginResource {

    public static final String LOGIN_ENDPOINT = "/login-api";
    private final LoginService loginService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        return loginService.login(dto) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}