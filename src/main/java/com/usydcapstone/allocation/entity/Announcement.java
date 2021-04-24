package com.usydcapstone.allocation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Announcement {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String title;
    private String authorId;
    private String time;
    private String content;
}