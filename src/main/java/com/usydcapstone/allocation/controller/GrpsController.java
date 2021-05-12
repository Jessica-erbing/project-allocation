package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GrpsController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/getAllGroup")
    public R getAllgroup() {
        List<Grps> group = groupService.getAllGroup();
        return R.ok().data("Group",group);
    }

    @GetMapping("/getGroupList")
    public R getGroupList() {
        List<GroupVo> groupList = groupService.getGroupList();
        return R.ok().data("list",groupList);
    }


}
