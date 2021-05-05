package com.usydcapstone.allocation.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.mapper.ProjectMapper;
import com.usydcapstone.allocation.service.AllocationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AllocationServiceImpl extends ServiceImpl<ProjectMapper, Project> implements AllocationService {

    @Override
    public List<Project> getAllProject() {
        List<Project> projectList = baseMapper.selectList(null);
        return projectList;

    }

    @Override
    public List<Project> getFullProject() {
        HashMap<String, Object> fullMap = new HashMap<>();
        fullMap.put("fullstatus",1);
        List<Project> fullProjectList = baseMapper.selectByMap(fullMap);
        return fullProjectList;
    }

    @Override
    public List<Project> getFreeProject() {
        HashMap<String, Object> freeMap = new HashMap<>();
        freeMap.put("fullstatus",0);
        List<Project> freeProjectList = baseMapper.selectByMap(freeMap);
        return freeProjectList;
    }

    @Override
    public List<Project> getPersonalProject() {
        HashMap<String, Object> freeMap = new HashMap<>();
        freeMap.put("units","COMP5709");
        List<Project> freeProjectList = baseMapper.selectByMap(freeMap);
        return freeProjectList;
    }

    @Override
    public List<Project> getGroupProject() {
        HashMap<String, Object> freeMap = new HashMap<>();
        freeMap.put("units","COMP5703");
        List<Project> freeProjectList = baseMapper.selectByMap(freeMap);
        return freeProjectList;
    }


    @Override
    public List<Project> findProject(){
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.like("title","1");
        List<Project> findProjectList = baseMapper.selectList(wrapper);
        return findProjectList;
    }


}
