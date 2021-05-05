package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.vo.GroupVo;
import com.usydcapstone.allocation.entity.vo.ResultVo;
import com.usydcapstone.allocation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin
public class ResultController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/getResult")
    public R getProjectGroup() {
        List<ResultVo> resultVoList = groupService.getResultList();
        return R.ok().data("resultList", resultVoList);
    }
}
