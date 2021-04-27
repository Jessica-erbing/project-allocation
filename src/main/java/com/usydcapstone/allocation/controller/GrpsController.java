package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GrpsController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/getAllGroup")
    public R getAllGroup() {
        List<Grps> group = groupService.getAllGroup();
        return R.ok().data("Group",group);
    }

    @PostMapping("/removeGroup")
    public R removeAdmin(@RequestBody Integer id) {
        groupService.removeGroup(id);
        return R.ok();
    }

}
