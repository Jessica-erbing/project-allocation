package com.usydcapstone.allocation.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GroupMapper extends BaseMapper<Grps> {
    public List<GroupVo> getGroupList();
    public List<GroupVo> getPageGroupList(IPage<GroupVo> groupPage, @Param("keyword") String keyword);

    public List<GroupVo> getProjectGroupList(Map params);
    public List<ResultVo> getResultList();
    public List<GroupVo> getUnassignedGroup();
    public List<UnallocatedGroupVo> getUnallocatedGroup();
    public List<GroupNumberVo> getGroupNumber(Map params);

    public List<GroupMemberVo> getGroupMember(Map params);






}
