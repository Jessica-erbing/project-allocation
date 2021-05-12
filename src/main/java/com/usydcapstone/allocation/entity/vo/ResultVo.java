package com.usydcapstone.allocation.entity.vo;

import com.usydcapstone.allocation.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo {
    private String id;
    private String groupNumber;
    private String projectTitle;
    private List<Student> studentList;
    private String projectClient;
}
