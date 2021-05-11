package com.usydcapstone.allocation.controller;

import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.vo.UnallocatedGroupVo;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/getUnallocatedGroup")
    public R getUnallocatedGroup(){
       List<UnallocatedGroupVo> unallocatedGroupVos = groupService.getUnallocatedGroup();
       return R.ok().data("unallocatedGroupVos", unallocatedGroupVos);

   }
}
