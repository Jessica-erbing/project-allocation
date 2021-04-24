package com.usydcapstone.allocation.service.impl;

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
}
