package com.usydcapstone.allocation.controller;

import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.vo.AnnouncementVo;
import com.usydcapstone.allocation.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @GetMapping("/getAnnouncementList")
    public R getAnnouncementList() {
        List<Announcement> list = announcementService.getAnnouncementList();
        return R.ok().data("list", list);
    }

    @PostMapping("/addAnnouncement")
    public R addAnnouncement(@RequestBody Announcement announcement) {
        announcementService.addAnnouncement(announcement);
        return R.ok();
    }

    @GetMapping("/getAnnouncement")
    public R getAnnouncement(@PathVariable String id) {

        AnnouncementVo announcementVo = announcementService.getAnnouncementVo(id);
        return R.ok().data('announcement', announcementVo);

    }


}
