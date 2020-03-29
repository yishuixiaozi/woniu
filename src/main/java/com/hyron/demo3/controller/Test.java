package com.hyron.demo3.controller;


import com.hyron.demo3.entity.User;
import com.hyron.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class Test {

    @Autowired
    UserService userService;

    User user = new User();

    //这里方法浏览器进入的方式就是   http;//localhost:8080/getAllUser


    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();

    }

    @ResponseBody
    public User getUserInfo(HttpServletRequest request, HttpServletResponse response){
        return user;
    }
}
