package com.usydcapstone.allocation.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Grps;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GrpsController {
    @Autowired
    private GroupService groupService;


    @GetMapping("/getAllGroup")
    public R getAllgroup() {
        List<Grps> group = groupService.getAllGroup();
        return R.ok().data("Group",group);
    }

    @GetMapping("/getGroupList")
    public R getGroupList() {
        List<GroupVo> groupList = groupService.getGroupList();
        return R.ok().data("list",groupList);
    }

    @PostMapping("/addGroup")
    public R addGroup(@RequestBody Grps group) {
        Grps savedGroup = groupService.saveGroup(group);
        return R.ok().data("group", savedGroup);
    }

    @PostMapping("/updateGroup")
    public R updateGroup(@RequestBody Grps group) {
        groupService.updateGroup(group);
        return R.ok();
    }

    @PostMapping("/removeGroup")
    public R removeGroup(@RequestParam String id) {
        groupService.removeGroup(id);
        return R.ok();
    }

    @GetMapping("/getGroupById")
    public R getGroupById(@RequestParam String id) {
        Grps group =  groupService.getGroupById(id);
        return R.ok().data("group", group);
    }

    @PostMapping("/removeGroupBatch")
    public R removeGroupBatch(@RequestParam List<String> idList) {
        groupService.removeGroupBatch(idList);
        return R.ok();
    }

    @GetMapping("/keywordGroupSearch")
    public R keywordGroupSearch(@RequestParam String keyword) {
        List<Grps> result = groupService.keywordGroupSearch(keyword);
        return R.ok().data("Group", result);
    }

    @GetMapping("/getGroupByPage")
    public R getGroupByPage(@RequestParam Long cpage){
        IPage<Grps> page = new Page<Grps>(cpage,8) ;
        IPage<Grps> iPage =  groupService.getGroupByPage(page);
        return R.ok().data("Group", iPage);
    }


    @GetMapping("/getPageGroupList")
    public R getPageGroupList(@RequestParam String keyword, Long page, Long limit) {
        IPage<GroupVo> groupVoPage = new Page<GroupVo>(page, limit);
        IPage<GroupVo> ipage = groupService.getPageGroupList(groupVoPage, keyword);
        int total = (int) ipage.getTotal();
        List<GroupVo> records = ipage.getRecords();
        return R.ok().data("total", total).data("list", records);
    }

}
