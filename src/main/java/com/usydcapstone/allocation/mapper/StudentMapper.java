package com.usydcapstone.allocation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usydcapstone.allocation.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
