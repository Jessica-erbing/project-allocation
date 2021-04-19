package com.usydcapstone.allocation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String type;
}

