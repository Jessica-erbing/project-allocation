package com.usydcapstone.allocation.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.vo.AnnouncementVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {
    public List<AnnouncementVo> getAnnouncementVoList();
}
