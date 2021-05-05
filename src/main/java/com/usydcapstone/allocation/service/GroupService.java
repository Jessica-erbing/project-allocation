package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.entity.vo.ResultVo;

import java.util.List;

public interface GroupService extends IService<Grps> {
    List<Grps> getAllGroup();

    List<GroupVo> getGroupList();

    List<GroupVo> getProjectGroupList();
    List<ResultVo> getResultList();
}
