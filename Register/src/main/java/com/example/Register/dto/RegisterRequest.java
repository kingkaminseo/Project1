package com.example.Register.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
}
