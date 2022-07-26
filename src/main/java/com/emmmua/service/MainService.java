package com.emmmua.service;

import com.emmmua.pojo.User;

import java.util.List;

public interface MainService {
    void reUser(User user);

    List<User> SelectAll();
}
