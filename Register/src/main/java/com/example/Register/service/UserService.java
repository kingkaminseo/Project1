package com.example.Register.service;

import com.example.Register.entity.User;
import com.example.Register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String email, String password, String name){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);

        return user;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean checkPassword(User user, String rawPassword){
        return user.getPassword().equals(rawPassword);
    }

}
