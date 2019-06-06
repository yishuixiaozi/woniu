package com.hyron.demo3.service;

import com.hyron.demo3.entity.User;

import java.util.List;
public interface UserService {
    List<User> getAllUser();

    User getUserInfo(String username,String password);
}
