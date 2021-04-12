package com.usydcapstone.allocation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    public String home() {
        return "hello world";
    }
}
