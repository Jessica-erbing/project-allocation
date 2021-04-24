package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.User;
import com.usydcapstone.allocation.entity.vo.AnnouncementVo;

import java.util.List;

public interface AnnouncementService extends IService<Announcement> {
    List<Announcement> getAnnouncementList();

    void addAnnouncement(Announcement announcement);

    AnnouncementVo getAnnouncementVo(String id);

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(String id);
}
