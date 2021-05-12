package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupNumberVo;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.entity.vo.ResultVo;
import com.usydcapstone.allocation.entity.vo.UnallocatedGroupVo;
import com.usydcapstone.allocation.mapper.GroupMapper;
import com.usydcapstone.allocation.service.GroupService;
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
    public Grps saveGroup(Grps group) {
        boolean saveSucceed = save(group);
        return group;
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

    @Override
    public IPage<GroupVo> getPageGroupList(IPage<GroupVo> groupPage, String keyword) {
        QueryWrapper<GroupVo> wrapper = new QueryWrapper<>();
        keyword = keyword.equals("") ? keyword : "%" + keyword + "%";
        IPage<GroupVo> groupListPage = groupPage.setRecords(groupMapper.getPageGroupList(groupPage, keyword));
        return groupListPage;
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
