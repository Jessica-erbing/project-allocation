package com.usydcapstone.allocation.entity;


import lombok.Data;

@Data
public class Student {
    private Long id;
    private Long uid;
    private String name;
    private String email;
    private String password;
}
