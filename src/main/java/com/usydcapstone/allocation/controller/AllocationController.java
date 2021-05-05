package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.service.GroupService;
import com.usydcapstone.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allocation")
@CrossOrigin
public class AllocationController {
    @Autowired
    private AllocationService allocationService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/getAllProject")
    public R getAllProject() {
        List<Project> projects = allocationService.getAllProject();
        return R.ok().data("Project",projects);
    }

    @GetMapping("/getFullProject")

    public R getFullProject() {
        List<Project> projects = allocationService.getFullProject();
        return R.ok().data("FullProject",projects);
    }

    @GetMapping("/getFreeProject")

    public R getFreeProject() {
        List<Project> projects = allocationService.getFreeProject();
        return R.ok().data("FreeProject",projects);
    }

    @GetMapping("/getPersonalProject")

    public R getPersonalProject() {
        List<Project> projects = allocationService.getPersonalProject();
        return R.ok().data("PersonalProject",projects);
    }


    @GetMapping("/getGroupProject")

    public R getGroupProject() {
        List<Project> projects = allocationService.getGroupProject();
        return R.ok().data("GroupProject",projects);
    }

    @GetMapping("/findProject")

    public R findProject() {
        List<Project> projects = allocationService.findProject();
        return R.ok().data("findProject",projects);
    }

    @GetMapping("/getProjectGroup")
    public R getProjectGroup() {
        List<GroupVo> projectgroups = groupService.getProjectGroupList();
        return R.ok().data("findProjectGroup",projectgroups);
    }

}
