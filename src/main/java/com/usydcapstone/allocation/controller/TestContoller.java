package com.usydcapstone.allocation.controller;

import com.usydcapstone.allocation.commonutils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestContoller {

    @GetMapping("/getTest")
    public R getTest() {
        return R.ok().data("words", "hello world");
    }
}
