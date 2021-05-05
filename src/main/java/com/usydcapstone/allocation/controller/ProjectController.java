package com.usydcapstone.allocation.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.entity.User;
import com.usydcapstone.allocation.service.ProjectService;
import com.usydcapstone.allocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService ProjectService;

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
        return R.ok().data("project", result);
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

}