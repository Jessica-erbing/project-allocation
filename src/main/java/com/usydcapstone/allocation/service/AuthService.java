package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Admin;
import org.springframework.stereotype.Service;

public interface AuthService {
    String adminLogin(Admin admin);
}
