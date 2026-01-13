package com.zhangjunjie.dao;

import com.zhangjunjie.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //List<Teacher> getTeacherAll();

    //获取指定老师下的所有学生以及老师信息
    Teacher getTeacher(@Param("tid") int id);
}
