package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.mapper.ProjectMapper;
import com.usydcapstone.allocation.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {


    @Override
    public boolean saveProject(Project project) {
        boolean projectNew = save(project);
        return projectNew;
    }

    @Override
    public boolean updateProject(Project project) {
        UpdateWrapper<Project> projectUpdateWrapper = new UpdateWrapper<>();
        projectUpdateWrapper
                .isNotNull("id")
        ;
        boolean projectUpdate = saveOrUpdate(project, projectUpdateWrapper);
        return projectUpdate;
    }

    @Override
    public boolean removeProject(String id) {
        boolean projectRemove = removeById(id);
        return projectRemove;
    }

    @Override
    public Project getProjectById(String id) {
        Project getProjectById = getById(id);
        return getProjectById;
    }


    @Override
    public List<Project> countTitle(Project project) {
        String newProjectTitle = project.getTitle();
        QueryWrapper<Project> projectTitleWrapper = new QueryWrapper<>();
        projectTitleWrapper.eq("title",newProjectTitle);
        List<Project> projectNumber = baseMapper.selectList(projectTitleWrapper);
        return projectNumber;
    }

    @Override
    public List<Project> getAllProject() {
        List<Project> projectList = baseMapper.selectList(null);
        return projectList;
    }

    @Override
    public IPage<Project> getByPage(IPage<Project> page) {
        IPage<Project> getByPage = page(page);
        return getByPage;
    }

    @Override
    public List<Project> keywordSearch(String keyword) {
        QueryWrapper<Project> projectSearchWrapper = new QueryWrapper<>();
        projectSearchWrapper
                .like("title",keyword)
        .or().like("id",keyword)
        .or().like("unit",keyword)
        .or().like("type",keyword);
        List<Project> searchResult = baseMapper.selectList(projectSearchWrapper);
        return searchResult;
    }


}