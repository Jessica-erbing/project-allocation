package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.AnnouncementVo;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
