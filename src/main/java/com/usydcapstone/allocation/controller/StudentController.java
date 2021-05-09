package com.usydcapstone.allocation.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.Project;
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

    @PostMapping("/addStudent")
    public R addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return R.ok();
    }

    @PostMapping("/updateStudent")
    public R updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return R.ok();
    }

    @PostMapping("/removeStudent")
    public R removeStudent(@RequestParam String id) {
        studentService.removeStudent(id);
        return R.ok();
    }

    @GetMapping("/getStudentById")
    public R getStudentById(@RequestParam String id) {
        Student student =  studentService.getStudentById(id);
        return R.ok().data("student", student);
    }

    @PostMapping("/removeStudentBatch")
    public R removeStudentBatch(@RequestParam List<String> idList) {
        studentService.removeStudentBatch(idList);
        return R.ok();
    }


    @GetMapping("/keywordSearchStudent")
    public R keywordSearchStudent(@RequestParam String keyword) {
        List<Student> result = studentService.keywordSearch(keyword);
        return R.ok().data("Student", result);
    }


    @GetMapping("/getStudentByPage")
    public R getStudentByPage(@RequestParam Long cpage){
        IPage<Student> page = new Page<Student>(cpage,8) ;
        IPage<Student> iPage =  studentService.getStudentByPage(page);
        return R.ok().data("Student", iPage);
    }

    @PostMapping("/resetPassword")
    public R resetPassword(@RequestParam String id) {
        Student student = studentService.resetPassword(id);
        studentService.updateStudent(student);
        return R.ok().data("student", student);
    }


}
