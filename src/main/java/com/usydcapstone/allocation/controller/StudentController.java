package com.usydcapstone.allocation.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usydcapstone.allocation.commonutils.ExcelUtil;
import com.usydcapstone.allocation.commonutils.R;
import com.usydcapstone.allocation.entity.Announcement;
import com.usydcapstone.allocation.entity.Project;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.entity.StudentExcel;
//import com.usydcapstone.allocation.listener.ExcelListener;
//import com.usydcapstone.allocation.listener.ExcelListener;
//import com.usydcapstone.allocation.listener.ExcelListener;
import com.usydcapstone.allocation.mapper.StudentMapper;
import com.usydcapstone.allocation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/batch/template")
    public void downloadTemplate(HttpServletResponse response) {
        String fileName = "Bulk_import_student_templates";
        String sheetName = "Bulk_import_student_templates";
        List<StudentExcel> userList = new ArrayList<>();
        userList.add(new StudentExcel("abc123","Jessica","example1@mail","123456"));
        userList.add(new StudentExcel("def123","Nick","example2@mail","123456"));
        try {
            ExcelUtil.writeExcel(response, userList, fileName, sheetName, StudentExcel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/batch/import")
    public R importData(MultipartFile file) throws ParseException {
        List<StudentExcel> userExcelList = null;
        // excel Synchronous reading of data
        try {
            userExcelList = EasyExcel.read(new BufferedInputStream(file.getInputStream())).head(StudentExcel.class).sheet().doReadSync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // UserExcelList into userList
        List<Student> userList = studentService.userExcelList2StudentList(userExcelList);
        // Data import database
        boolean studentbatch = studentService.batchInsertOrUpdate(userList);
        return R.ok().data("student", studentbatch);
    }

    @GetMapping("/getGroupMembers")
    public R getGroupMembers(@RequestParam String groupid) {
        List<Student> GroupMembers = studentService.getGroupMembers(groupid);
        return R.ok().data("Student", GroupMembers);
    }

}
