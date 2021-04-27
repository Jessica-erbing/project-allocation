package com.usydcapstone.allocation.controller;


import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentList")
    public R getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return R.ok().data("students",students);
    }

    @PostMapping("/removeStudent")
    public R removeStudent(@RequestBody Integer id) {
        studentService.removeStudent(id);
        return R.ok();
    }
}
