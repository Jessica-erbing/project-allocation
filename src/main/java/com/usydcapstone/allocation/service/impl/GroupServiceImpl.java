package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.*;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Grps> implements GroupService {

    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<Grps> getAllGroup() {
        List<Grps> grpsList = baseMapper.selectList(null);
        return grpsList;
    }

    @Override
    public List<GroupVo> getGroupList() {
        return groupMapper.getGroupList();
    }

    @Override
    public List<GroupVo> getProjectGroupList(Map params) {
        return groupMapper.getProjectGroupList(params);
    }

    @Override
    public List<ResultVo> getResultList(){
        return
                groupMapper.getResultList();
    }

    @Override
    public List<GroupVo> getUnassignedGroup(){
        return groupMapper.getUnassignedGroup();
    }

    @Override
    public List<GroupNumberVo> getGroupNumber(Map params){return groupMapper.getGroupNumber(params);}

    @Override
    public  List<UnallocatedGroupVo> getUnallocatedGroup(){
        return groupMapper.getUnallocatedGroup();
    }
}
