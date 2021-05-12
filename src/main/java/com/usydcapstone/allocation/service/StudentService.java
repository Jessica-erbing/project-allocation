package com.usydcapstone.allocation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.usydcapstone.allocation.entity.Student;
import com.usydcapstone.allocation.entity.StudentExcel;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getAllStudent();
    boolean saveStudent(Student student);
    boolean updateStudent(Student student);
    boolean removeStudent(String id);
    Student getStudentById(String id);
    boolean removeStudentBatch(List<String> idList);
    IPage<Student> getStudentByPage(IPage<Student> page);
    List<Student> keywordSearch(String keyword);
    Student resetPassword(String id);
    boolean batchInsertOrUpdate(List<Student> userList);
    List<Student> userExcelList2StudentList(List<StudentExcel> userExcelList) throws ParseException;

}
