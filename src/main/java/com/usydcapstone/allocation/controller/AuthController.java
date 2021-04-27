package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.ExceptionHandler.AllocationException;
import com.usydcapstone.allocation.commonutils.JwtUtils;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.service.AdminService;
import com.usydcapstone.allocation.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    AdminService adminService;

    @PostMapping("/adminLogin")
    public R adminLogin(@RequestBody Admin admin) {
        String token = "";
        try {
            token = authService.adminLogin(admin);
        } catch (AllocationException e) {
            Integer errorCode = e.getCode();
            return R.error().code(errorCode).message(e.getMsg());
        }
        return R.ok().data("token", token);
    }

    @GetMapping("/getAdminInfo")
    public R getAdminInfo(HttpServletRequest request) {
        String id = JwtUtils.getAdminIdByJwtToken(request);
        Admin queryAdmin = adminService.getAdminById(id);

        return R.ok().data("admin", queryAdmin);
    }
}
