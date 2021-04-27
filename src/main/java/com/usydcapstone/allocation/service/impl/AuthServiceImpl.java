package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.ExceptionHandler.AllocationException;
import com.usydcapstone.allocation.commonutils.JwtUtils;
import com.usydcapstone.allocation.commonutils.ResultCode;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.mapper.AdminMapper;
import com.usydcapstone.allocation.service.AdminService;
import com.usydcapstone.allocation.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String adminLogin(Admin admin) {
        String email = admin.getEmail();
        String password = admin.getPassword();

        // Validate empty email or password
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new AllocationException(ResultCode.EMPTY_EMAIL_PASSWORD, "Empty email or password");
        }

        // Validate email exists
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        Admin queryAdmin = adminMapper.selectOne(wrapper);

        if (queryAdmin == null) {
            throw new AllocationException(ResultCode.EMAIL_NOT_EXIST, "Email not exists");
        }

        // Validate password matches the email
        // TODO MD5 encode
        if (!password.equals(queryAdmin.getPassword())) {
            throw new AllocationException(ResultCode.ERROR_PASSWORD, "Wrong password");
        }

        // Login Succeed
        String token = JwtUtils.getJwtToken(queryAdmin.getId(), queryAdmin.getName());

        return token;
    }
}
