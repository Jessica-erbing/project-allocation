package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> getAllUser();
}