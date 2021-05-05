package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.entity.vo.GroupVo;

import java.util.List;

public interface GroupService extends IService<Grps> {
    List<Grps> getAllGroup();
    List<GroupVo> getGroupList();
    boolean saveGroup(Grps group);
    boolean updateGroup(Grps group);
    boolean removeGroup(String id);
    Grps getGroupById(String id);
    boolean removeGroupBatch(List<String> idList);
    IPage<Grps> getGroupByPage(IPage<Grps> page);
    List<Grps> keywordGroupSearch(String keyword);
}
