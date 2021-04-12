package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.User;
import com.usydcapstone.allocation.mapper.UserMapper;
import com.usydcapstone.allocation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getAllUser() {
        List<User> userList = baseMapper.selectList(null);
        return userList;
    }
}
