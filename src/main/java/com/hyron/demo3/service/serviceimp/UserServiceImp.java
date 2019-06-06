package com.hyron.demo3.service.serviceimp;

import com.hyron.demo3.dao.UserDao;
import com.hyron.demo3.entity.User;
import com.hyron.demo3.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
   @Resource
    UserDao userDao;
   //获取用户表的所有信息
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
    //获取某个满足条件的用户对象信息
    @Override
    public User getUserInfo(String username, String password) {
        return userDao.getUserInfo(username,password);
    }
}
