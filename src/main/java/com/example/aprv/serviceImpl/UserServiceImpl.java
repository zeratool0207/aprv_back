package com.example.aprv.serviceImpl;

import com.example.aprv.mapper.UserMapper;
import com.example.aprv.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public Map<String, Object> getLogin(String id) {
        return userMapper.getLogin(id);
    }
}
