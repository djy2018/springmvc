package com.wisely.springmvc.service.impl;

import com.wisely.springmvc.domain.User;
import com.wisely.springmvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by dujiayong on 2020/4/5.
 */
@Service("userService")
//public class UserServiceImpl {
public class UserServiceImpl implements UserService {

    @Override
    public User login(Integer userId) {
        System.out.println("user login...");
        return new User("djy","123456");
    }

}
