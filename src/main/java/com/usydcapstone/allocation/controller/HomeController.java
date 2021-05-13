package com.usydcapstone.allocation.controller;

import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.vo.GroupMemberVo;
import com.usydcapstone.allocation.entity.vo.UnallocatedGroupVo;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/getGroupMember")
    public R getGroupMember(@RequestParam String groupId){
        Map params = new HashMap<>();
        params.put("id",groupId);
        List<GroupMemberVo> groupMemberVos = groupService.getGroupMember(params);
        return R.ok().data("groupMember",groupMemberVos);
    }

}
