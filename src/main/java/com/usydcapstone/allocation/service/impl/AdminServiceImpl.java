package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.mapper.AdminMapper;
import com.usydcapstone.allocation.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {


    @Override
    public boolean saveAdmin(Admin admin) {

        boolean adminNew = save(admin);

        return adminNew;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        UpdateWrapper<Admin> adminUpdateWrapper = new UpdateWrapper<>();
        adminUpdateWrapper.eq("id", null);
        boolean adminUpdate = saveOrUpdate(admin, adminUpdateWrapper);
        return adminUpdate;
    }

    @Override
    public boolean removeAdmin(Integer id) {

//        QueryWrapper<Admin> adminRemoveWrapper = new QueryWrapper<>();
//        adminRemoveWrapper.eq("id", id);
        boolean adminRemove = removeById(id);
        return adminRemove;
    }


    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList = baseMapper.selectList(null);
        return adminList;
    }


//    @Override
//    public Integer countAdmin() {
//        Integer adminNumber = baseMapper.selectCount(null);
//        return adminNumber;
//    }

}