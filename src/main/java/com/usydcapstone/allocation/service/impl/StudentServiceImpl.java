package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.mapper.StudentMapper;
import com.usydcapstone.allocation.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public List<Student> getAllStudent(){
        ArrayList<Student> studentList = (ArrayList<Student>) baseMapper.selectList(null);



        return studentList;
    }
}
