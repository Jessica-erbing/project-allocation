package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.ExceptionHandler.AllocationException;
import com.usydcapstone.allocation.commonutils.JwtUtils;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.service.AdminService;
import com.usydcapstone.allocation.service.AuthService;
import com.usydcapstone.allocation.service.StudentService;
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

    @Autowired
    StudentService studentService;

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

    @PostMapping("/studentLogin")
    public R studentLogin(@RequestBody Student student) {
        String token = "";
        try {
            token = authService.studentLogin(student);
        } catch (AllocationException e) {
            Integer errorCode = e.getCode();
            return R.error().code(errorCode).message(e.getMsg());
        }
        return R.ok().data("token", token);
    }

    @GetMapping("/getStudentInfo")
    public R getStudentInfo(HttpServletRequest request) {
        String id = JwtUtils.getStudentIdByJwtToken(request);
        Student studentQuery = studentService.getStudentById(id);

        return R.ok().data("student", studentQuery);
    }
}
