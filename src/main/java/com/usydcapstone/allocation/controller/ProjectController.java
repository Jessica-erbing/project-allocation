package com.usydcapstone.allocation.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.*;
import com.usydcapstone.allocation.entity.vo.GroupNumberVo;
import com.usydcapstone.allocation.service.GroupService;
import com.usydcapstone.allocation.service.ProjectService;
import com.usydcapstone.allocation.service.StudentService;
import com.usydcapstone.allocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService ProjectService;
    @Autowired
    private GroupService GroupService;
    /*@Autowired
    private StudentService StudentService;*/

    @GetMapping("/getAllProject")
    public R getAllProject() {
        List<Project> projects = ProjectService.getAllProject();
        return R.ok().data("Project", projects);
    }

    @GetMapping("/getProjectById")
    public R getAdminById(@RequestParam String id) {
        Project project =  ProjectService.getProjectById(id);
        return R.ok().data("project", project);
    }

    @GetMapping("/keywordSearch")
    public R keywordSearch(@RequestParam String keyword) {
        List<Project> result = ProjectService.keywordSearch(keyword);
        return R.ok().data("project:", result);
    }


    @PostMapping("/saveProject")
    public R saveProject(@RequestBody Project project) {
        if (ProjectService.countTitle(project).size() > 0) {
            return R.error().code(2100).message("The title is repeated.");
        } else {
            ProjectService.saveProject(project);
            return R.ok();
        }
    }

    @PostMapping("/updateProject")
    public R updateProject(@RequestBody Project project) {
        ProjectService.updateProject(project);
        return R.ok();
    }

    @PostMapping("/removeProject")
    public R removeProject(@RequestParam String id) {
        ProjectService.removeProject(id);
        return R.ok();
    }

    @GetMapping("/getByPage")
    public R getByPage(@RequestParam Long cpage){
        IPage<Project> page = new Page<Project>(cpage,6) ;
        IPage<Project> iPage =  ProjectService.getByPage(page);
        return R.ok().data("project", iPage);
    }



    /*@GetMapping("getGroupId")
    public R getGroupId(){
        Student student = StudentService.getById(20004);
        Long groupId = student.getGroupId();
        return R.ok().data("GroupId",groupId);
    }*/

    @GetMapping("/allocated")
    public R allocated(
        @RequestParam int pre1,
        @RequestParam int pre2,
        @RequestParam int pre3,
        @RequestParam String groupId

    ){
        int [] preList = new int[]{pre1,pre2,pre3};
       /* Student student = StudentService.getById(studentId);
        Long groupId = student.getGroupId();*/

        for (int i = 0; i < 3; i++) {
            int projectId = preList[i];
            int num;//current group number
            Map params = new HashMap<>();
            params.put("id",projectId);
            List<GroupNumberVo> groupNumberVos = GroupService.getGroupNumber(params);
            int row = groupNumberVos.size();
            if (row == 0){
                num = 0;
            }else{
                num = Integer.parseInt(groupNumberVos.get(0).getNumber());
            };
            Project project = ProjectService.getProject(projectId);
            int nums = Integer.parseInt(project.getGroupnum());// get group limit
            if(num < nums - 1){
                //add group
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",groupId);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(pre1));
                grps.setPre2(Integer.toString(pre2));
                grps.setPre3(Integer.toString(pre3));
                grps.setProjectId(projectId);
                GroupService.update(grps,updateGroupWrapper);
                break;
            }else if (num == nums - 1){
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",groupId);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(pre1));
                grps.setPre2(Integer.toString(pre2));
                grps.setPre3(Integer.toString(pre3));
                grps.setProjectId(projectId);
                GroupService.update(grps,updateGroupWrapper);

                UpdateWrapper<Project> updateProjectWrapper = new UpdateWrapper<>();
                updateProjectWrapper.eq("id",projectId);
                Project projects = new Project();
                project.setFullstatus(1);
                ProjectService.update(projects,updateProjectWrapper);
                break;
            }else {
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",groupId);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(pre1));
                grps.setPre2(Integer.toString(pre2));
                grps.setPre3(Integer.toString(pre3));
                grps.setProjectId(0);
                GroupService.update(grps,updateGroupWrapper);
            }

        }


        /*UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
        updateGroupWrapper.eq("id",4);
        Grps grps = new Grps();
        grps.setPre1(Integer.toString(1));
        grps.setPre2(Integer.toString(2));
        grps.setPre3(Integer.toString(3));
        GroupService.update(grps,updateGroupWrapper);*/
        return R.ok();

    }

    @GetMapping("/allocate")
    public R allocate(
            /*@RequestParam int pre1,
            @RequestParam int pre2,
            @RequestParam int pre3,
            @RequestParam String groupId*/
    ){
        int [] preList = new int[]{1,2,3};
        for (int i = 0; i < 3; i++) {
            int projectId = preList[i];
            int num;//current group number
            Map params = new HashMap<>();
            params.put("id",projectId);
            List<GroupNumberVo> groupNumberVos = GroupService.getGroupNumber(params);
            int row = groupNumberVos.size();
            if (row == 0){
                num = 0;
            }else{
                num = Integer.parseInt(groupNumberVos.get(0).getNumber());
            };
            Project project = ProjectService.getProject(projectId);
            int nums = Integer.parseInt(project.getGroupnum());// get group limit
            if(num < nums - 1){
                //add group
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",4);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(1));
                grps.setPre2(Integer.toString(2));
                grps.setPre3(Integer.toString(3));
                grps.setProjectId(projectId);
                GroupService.update(grps,updateGroupWrapper);
                break;
            }else if (num == nums - 1){
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",4);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(1));
                grps.setPre2(Integer.toString(2));
                grps.setPre3(Integer.toString(3));
                grps.setProjectId(projectId);
                GroupService.update(grps,updateGroupWrapper);

                UpdateWrapper<Project> updateProjectWrapper = new UpdateWrapper<>();
                updateProjectWrapper.eq("id",projectId);
                Project projects = new Project();
                project.setFullstatus(1);
                ProjectService.update(projects,updateProjectWrapper);
                break;
            }else {
                UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
                updateGroupWrapper.eq("id",4);
                Grps grps = new Grps();
                grps.setPre1(Integer.toString(1));
                grps.setPre2(Integer.toString(2));
                grps.setPre3(Integer.toString(3));
                grps.setProjectId(0);
                GroupService.update(grps,updateGroupWrapper);
            }

        }


        /*UpdateWrapper<Grps> updateGroupWrapper = new UpdateWrapper<>();
        updateGroupWrapper.eq("id",4);
        Grps grps = new Grps();
        grps.setPre1(Integer.toString(1));
        grps.setPre2(Integer.toString(2));
        grps.setPre3(Integer.toString(3));
        GroupService.update(grps,updateGroupWrapper);*/
        return R.ok();

    }

}