package com.usydcapstone.allocation.entity.vo;

import com.usydcapstone.allocation.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class GroupVo {
    private String id;
    private String groupNumber;
    private List<Student> studentList;
}
