package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.*;

import java.util.List;
import java.util.Map;

public interface GroupService extends IService<Grps> {
    List<Grps> getAllGroup();
    List<GroupVo> getGroupList();
    Grps saveGroup(Grps group);
    boolean updateGroup(Grps group);
    boolean removeGroup(String id);
    Grps getGroupById(String id);
    boolean removeGroupBatch(List<String> idList);
    IPage<Grps> getGroupByPage(IPage<Grps> page);
    List<Grps> keywordGroupSearch(String keyword);

    IPage<GroupVo> getPageGroupList(IPage<GroupVo> groupPage, String keyword);


    List<GroupVo> getProjectGroupList(Map params);
    List<ResultVo> getResultList();
    List<GroupVo> getUnassignedGroup();
    List<GroupNumberVo> getGroupNumber(Map params);
    List<UnallocatedGroupVo> getUnallocatedGroup();
    List<GroupMemberVo> getGroupMember(Map params);

}
