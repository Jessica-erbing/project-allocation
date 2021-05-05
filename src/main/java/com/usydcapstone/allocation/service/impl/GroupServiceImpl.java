package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
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

    @Override
    public boolean saveGroup(Grps group) {
        boolean groupNew = save(group);
        return groupNew;
    }

    @Override
    public boolean updateGroup(Grps group) {
        boolean groupUpdate = updateById(group);
        return groupUpdate;
    }

    @Override
    public boolean removeGroup(String id) {
        boolean groupRemove = removeById(id);
        return groupRemove;
    }

    @Override
    public Grps getGroupById(String id) {
        Grps getGroupById = getById(id);
        return getGroupById;
    }

    @Override
    public boolean removeGroupBatch(List<String> idList) {
        boolean removeGroupBatch = removeByIds(idList);
        return removeGroupBatch;
    }

    @Override
    public IPage<Grps> getGroupByPage(IPage<Grps> page) {
        IPage<Grps> getGroupByPage = page(page);
        return getGroupByPage;
    }

    @Override
    public List<Grps> keywordGroupSearch(String keyword) {
        QueryWrapper<Grps> GroupSearchWrapper = new QueryWrapper<>();
        GroupSearchWrapper
                .like("id",keyword)
                .or().like("group_number",keyword)
                .or().like("pre2",keyword)
                .or().like("pre3",keyword)
                .or().like("pre1",keyword);
        List<Grps> searchResult = baseMapper.selectList(GroupSearchWrapper);
        return searchResult;
    }

}
