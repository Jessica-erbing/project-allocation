package com.usydcapstone.allocation.entity.vo;

import com.usydcapstone.allocation.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class GroupVo {
    private Long id;
    private String groupNumber;
    private String preferField;
    private List<Student> studentList;
    private int pre1;
    private int pre2;
    private int pre3;
}
