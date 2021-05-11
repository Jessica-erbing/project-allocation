package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Project;

import java.util.List;

public interface AllocationService extends IService<Project> {
    List<Project> getAllProject();
    List<Project> getFullProject();
    List<Project> getFreeProject();
    List<Project> getPersonalProject();
    List<Project> getGroupProject();

    List<Project> findProject(String keyword,String fullStatus, String unit);

}
