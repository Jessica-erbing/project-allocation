package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.vo.AnnouncementVo;
import com.usydcapstone.allocation.mapper.AnnouncementMapper;
import com.usydcapstone.allocation.service.AdminService;
import com.usydcapstone.allocation.service.AnnouncementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

    @Autowired
    AdminService adminService;

    @Override
    public List<Announcement> getAnnouncementList() {

        return baseMapper.selectList(null);
    }

    @Override
    public void addAnnouncement(Announcement announcement) {
        String time = String.valueOf(System.currentTimeMillis());
        announcement.setTime(time);
        this.save(announcement);
    }

    @Override
    public AnnouncementVo getAnnouncementVo(String id) {
        Announcement announcement = baseMapper.selectById(id);

        AnnouncementVo announcementVo = new AnnouncementVo();
        BeanUtils.copyProperties(announcement, announcementVo);

        String authorId = announcement.getAuthorId();
        Admin adminInfo = adminService.getAdminById(authorId);
        if (adminInfo != null) {
            announcementVo.setAuthorId(authorId);
            announcementVo.setAuthorName(adminInfo.getName());
            announcementVo.setAuthorAvatar(adminInfo.getAvatar());
        }
        return announcementVo;
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        String time = String.valueOf(System.currentTimeMillis());
        announcement.setTime(time);
        this.updateById(announcement);
    }

    @Override
    public void deleteAnnouncement(String id) {
        baseMapper.deleteById(id);
    }
}