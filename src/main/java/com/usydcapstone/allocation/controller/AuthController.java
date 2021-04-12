package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/login")
    public R login() {
        return R.ok().data("message", "LOL");
    }
}
