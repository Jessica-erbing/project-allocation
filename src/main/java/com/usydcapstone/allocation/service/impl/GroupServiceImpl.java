package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Grps> implements GroupService {

    @Override
    public List<Grps> getAllGroup() {
        List<Grps> grpsList = baseMapper.selectList(null);
        return grpsList;
    }

    @Override
    public boolean removeGroup(Integer id){
        boolean groupRemove = removeById(id);
        return groupRemove;
    }

    @Override
    public List<Grps> getProjectGroup() {
        QueryWrapper<Grps> wrapper = new QueryWrapper<>();
        wrapper.eq("pre1",3).or().eq("pre2",3).or().eq("pre3",3);
        List<Grps> projectgroups = baseMapper.selectList(wrapper);
        return projectgroups;
    }
}
