package com.wugang.dao;

import com.wugang.pojo.Student;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/15 20:08
 */
public interface StudentMapper {
    /**
     * 查询所有的学生信息以及老师的信息
     * @return
     */
    List<Student> getStudent();

    /**
     * 查询所有的学生信息以及老师的信息
     * @return
     */
    List<Student> getStudent2();
}
