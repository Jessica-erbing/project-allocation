package com.usydcapstone.allocation.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.awt.*;

@Data
public class Project {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String title;
    private String client;
    private String type;
    private String unit;
    private String groupnum;
    private String skills;
    private String details;
    private String annotation;
}


