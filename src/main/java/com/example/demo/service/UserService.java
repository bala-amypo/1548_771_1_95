package com.example.demo3.service;

import com.example.demo3.model.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
}
