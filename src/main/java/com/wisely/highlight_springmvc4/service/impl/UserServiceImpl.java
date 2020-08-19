package com.wisely.highlight_springmvc4.service.impl;

import com.wisely.highlight_springmvc4.domain.User;
import com.wisely.highlight_springmvc4.service.UserService;
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
