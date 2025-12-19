package com.example.demo4.service;

import com.example.demo4.model.User;

public interface UserService {

    User register(User user);

    User findByEmail(String email);
}
