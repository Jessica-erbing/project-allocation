package com.usydcapstone.allocation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper extends BaseMapper<Grps> {
    public List<GroupVo> getGroupList();
    public IPage<GroupVo> getPageGroupList(IPage<GroupVo> groupPage);
}
