package com.usydcapstone.allocation.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AnnouncementVo {
    private String id;
    private String title;
    private String authorName;
    private String authorAvatar;
    private String authorId;
    private String time;
    private String content;
}
