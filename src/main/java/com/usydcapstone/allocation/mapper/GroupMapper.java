package com.usydcapstone.allocation.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper extends BaseMapper<Grps> {
    public List<GroupVo> getGroupList();
    public List<GroupVo> getPageGroupList(IPage<GroupVo> groupPage, @Param("keyword") String keyword);
}
