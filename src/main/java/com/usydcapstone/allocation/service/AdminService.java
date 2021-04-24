package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Admin;


import java.util.List;

public interface AdminService extends IService<Admin> {
    boolean  saveAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
    boolean removeAdmin(Integer id);
    Admin getAdminById(Integer id);

    List<Admin> getAllAdmin();
    List<Admin> countEmail(Admin admin);

}


