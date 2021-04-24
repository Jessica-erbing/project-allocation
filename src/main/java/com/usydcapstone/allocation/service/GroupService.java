package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Grps;

import java.util.List;

public interface GroupService extends IService<Grps> {
    List<Grps> getAllGroup();
}
