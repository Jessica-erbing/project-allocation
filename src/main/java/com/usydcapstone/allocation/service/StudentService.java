package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getAllStudent();

    boolean removeStudent(Integer id);
}
