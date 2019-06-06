package com.hyron.demo3.dao;

import com.hyron.demo3.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    List<User> getAllUser();

    User getUserInfo(@Param(value="username") String username,
                     @Param(value="password") String password);
}
