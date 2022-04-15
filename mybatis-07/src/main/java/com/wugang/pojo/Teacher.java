package com.wugang.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/15 20:05
 */
@Data
public class Teacher {
    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 一个老师有多个学生
     */
    private List<Student> students;
}
