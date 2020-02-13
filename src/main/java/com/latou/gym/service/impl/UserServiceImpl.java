package com.latou.gym.service.impl;

import com.latou.gym.domain.User;
import com.latou.gym.mapper.UserMapper;
import com.latou.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getbyId(long id) {
        return userMapper.findById(id);
    }
}
