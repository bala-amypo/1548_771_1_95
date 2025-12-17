
package com.example.demo1.service;

import com.example.demo1.model.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
}
