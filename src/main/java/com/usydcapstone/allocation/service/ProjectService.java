package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Project;


import java.util.List;

public interface ProjectService extends IService<Project> {
    boolean saveProject(Project project);
    boolean updateProject(Project project);
    boolean removeProject(String id);
    Project getProjectById(String id);
    List<Project> countTitle(Project project);
    List<Project> getAllProject();


}