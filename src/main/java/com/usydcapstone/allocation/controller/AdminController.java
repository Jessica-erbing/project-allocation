package com.usydcapstone.allocation.controller;

import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Admin;
import com.usydcapstone.allocation.entity.User;
import com.usydcapstone.allocation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;;

    @GetMapping("/getAdminList")
    public R getAdminList() {

        List<Admin> admins = adminService.getAllAdmin();
        return R.ok().data("admins", admins);
    }

//    @GetMapping("/countAdmin")
//    public R countAdmin() {
//
//        Integer adminNum = adminService.countAdmin();
//        return R.ok().data("number", adminNum);
//    }

    @PostMapping("/saveAdmin")
    public R saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return R.ok();
    }

    @PostMapping("/updateAdmin")
    public R updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return R.ok();
    }

    @PostMapping("/removeAdmin")
    public R removeAdmin(@RequestBody Integer id) {
        adminService.removeAdmin(id);
        return R.ok();
    }
}
