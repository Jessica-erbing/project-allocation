package com.usydcapstone.allocation.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.entity.vo.GroupNumberVo;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
import com.usydcapstone.allocation.service.AllocationService;
import com.usydcapstone.allocation.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/allocation")
@CrossOrigin
public class AllocationController {
    @Autowired
    private AllocationService allocationService;

    @Autowired
    private GroupService groupService;
    @Autowired
    private ProjectService projectService;

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

    public R findProject(
            @RequestParam String keyword,
            @RequestParam String fullStatus,
            @RequestParam String unit
    ) {
        List<Project> projects = allocationService.findProject(keyword,fullStatus,unit);
        return R.ok().data("findProject",projects);
    }

    @GetMapping("/getProjectGroup")
    public R getProjectGroup(@RequestParam int id) {
        Map params = new HashMap<>();
        params.put("id",id);
        List<GroupVo> projectgroups = groupService.getProjectGroupList(params);
        return R.ok().data("findProjectGroup",projectgroups);
    }

    @GetMapping("/getUnassignedGroup")
    public R unassignedGroup(){
        List<GroupVo> unassignedGroup = groupService.getUnassignedGroup();
        return R.ok().data("unassignedGroup", unassignedGroup);
    }


    @GetMapping("/add")
    public R add(){
        UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
        updateGroupWrapper.eq("id",4);
        Grps grps = new Grps();
        grps.setProjectId(3);
        groupService.update(grps,updateGroupWrapper);
        return R.ok();
    }




    @GetMapping ("/addGroup")
    public R addGroup(
            @RequestParam int ProjectId,
            @RequestParam int groupId

    ) {
        int num;//current group number
        Map params = new HashMap<>();
        params.put("id",ProjectId);
        List<GroupNumberVo> groupNumberVos = groupService.getGroupNumber(params);
        int row = groupNumberVos.size();
        if (row == 0){
            num = 0;
        }else{
            num = Integer.parseInt(groupNumberVos.get(0).getNumber());
        };
        Project project = projectService.getProject(ProjectId);
        int nums = Integer.parseInt(project.getGroupnum());
        if (num < nums - 1){
            UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
            updateGroupWrapper.eq("id",groupId);
            Grps grps = new Grps();
            grps.setProjectId(ProjectId);
            groupService.update(grps,updateGroupWrapper);
            return R.ok();
        }else if(num == nums -1) {
            UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
            updateGroupWrapper.eq("id",groupId);
            Grps grps = new Grps();
            grps.setProjectId(ProjectId);
            groupService.update(grps,updateGroupWrapper);

            UpdateWrapper<Project> updateProjectWrapper = new UpdateWrapper<>();
            updateProjectWrapper.eq("id",ProjectId);
            Project projects = new Project();
            project.setFullstatus(1);
            projectService.update(projects,updateProjectWrapper);
            return R.ok();

        }else {
            return R.error();
        }


    }


    @GetMapping ("/deleteGroup")
    public R deleteGroup(
            @RequestParam int ProjectId,
            @RequestParam int groupId

    ) {
        int num;
        Map params = new HashMap<>();
        params.put("id",ProjectId);
        List<GroupNumberVo> groupNumberVos = groupService.getGroupNumber(params);
        int row = groupNumberVos.size();
        if (row == 0){
            num = 0;
        }else{
            num = Integer.parseInt(groupNumberVos.get(0).getNumber());
        };
        Project project = projectService.getProject(ProjectId);
        int nums = Integer.parseInt(project.getGroupnum());
        if (num == nums){
            UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
            updateGroupWrapper.eq("id",groupId);
            Grps grps = new Grps();
            grps.setProjectId(0);
            groupService.update(grps,updateGroupWrapper);

            UpdateWrapper<Project> updateProjectWrapper = new UpdateWrapper<>();
            updateProjectWrapper.eq("id",ProjectId);
            Project projects = new Project();
            project.setFullstatus(0);
            projectService.update(projects,updateProjectWrapper);
            return R.ok();
        }else {
            UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
            updateGroupWrapper.eq("id",groupId);
            Grps grps = new Grps();
            grps.setProjectId(0);
            groupService.update(grps,updateGroupWrapper);
            return R.ok();
        }


    }


}
