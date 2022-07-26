package com.emmmua.service;

import com.emmmua.pojo.User;

public interface UserService {
    User login(User user);
    boolean register(User user);
}
