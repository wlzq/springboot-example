package org.allen.demo.service.impl;

import org.allen.demo.domain.User;
import org.allen.demo.mapper.UserMapper;
import org.allen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
