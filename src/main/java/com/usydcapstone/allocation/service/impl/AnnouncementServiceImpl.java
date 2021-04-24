package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        QueryWrapper<Announcement> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Announcement announcement = baseMapper.selectById(wrapper);

        String authorId = announcement.getAuthorId();
        // TODO
        // Get admin info by authorID

        AnnouncementVo announcementVo = new AnnouncementVo();
        BeanUtils.copyProperties(announcement, announcementVo);

        return announcementVo;
    }
}