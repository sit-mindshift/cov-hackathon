package com.sit.cov.hackatron.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class LoginDTO {

    private String username;
    private String password;

}