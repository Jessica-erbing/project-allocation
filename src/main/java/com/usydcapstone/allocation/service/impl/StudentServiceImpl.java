package com.usydcapstone.allocation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    @Override
    public boolean saveStudent(Student student) {
        boolean studentNew = save(student);
        return studentNew;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean studentUpdate = updateById(student);
        return studentUpdate;
    }

    @Override
    public boolean removeStudent(String id) {
        boolean studentRemove = removeById(id);
        return studentRemove;
    }

    @Override
    public Student getStudentById(String id) {
        Student getStudentById = getById(id);
        return getStudentById;
    }

    @Override
    public boolean removeStudentBatch(List<String> idList) {
        boolean removeStudentBatch = removeByIds(idList);
        return removeStudentBatch;
    }

    @Override
    public IPage<Student> getStudentByPage(IPage<Student> page) {
        IPage<Student> getStudentByPage = page(page);
        return getStudentByPage;
    }

    @Override
    public List<Student> keywordSearch(String keyword) {
        QueryWrapper<Student> StudentSearchWrapper = new QueryWrapper<>();
        StudentSearchWrapper
                .like("id",keyword)
                .or().like("email",keyword)
                .or().like("name",keyword);
        List<Student> searchResult = baseMapper.selectList(StudentSearchWrapper);
        return searchResult;
    }

    @Override
    public Student resetPassword(String id) {
        Student student = baseMapper.selectById(id);
        student.setPassword("123456");

        return student;
    }
}
