package com.example.Register.controller;

import com.example.Register.dto.LoginRequest;
import com.example.Register.dto.RegisterRequest;
import com.example.Register.entity.User;
import com.example.Register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        userService.registerUser(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName());
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && userService.checkPassword(user, loginRequest.getPassword())) {
            return ResponseEntity.ok(user.getName() + "님 환영합니다!");
        } else {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }
}

