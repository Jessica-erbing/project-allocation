package com.usydcapstone.allocation.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
