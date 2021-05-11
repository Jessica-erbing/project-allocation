package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupNumberVo;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.entity.vo.ResultVo;
import com.usydcapstone.allocation.entity.vo.UnallocatedGroupVo;

import java.util.List;
import java.util.Map;

public interface GroupService extends IService<Grps> {
    List<Grps> getAllGroup();

    List<GroupVo> getGroupList();

    List<GroupVo> getProjectGroupList(Map params);
    List<ResultVo> getResultList();
    List<GroupVo> getUnassignedGroup();
    List<GroupNumberVo> getGroupNumber(Map params);
    List<UnallocatedGroupVo> getUnallocatedGroup();
}
