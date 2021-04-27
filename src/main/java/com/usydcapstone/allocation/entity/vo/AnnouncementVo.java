package com.usydcapstone.allocation.entity.vo;

import com.usydcapstone.allocation.entity.Admin;
import lombok.Data;

@Data
public class AnnouncementVo {
    private String id;
    private String title;
    private Admin author;
    private String authorId;
    private String time;
    private String content;
}
