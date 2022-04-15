package com.wugang.pojo;

import lombok.Data;

/**
 * @author wugang
 * @date 2022/4/15 20:06
 */
@Data
public class Student {
    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 老师id
     */
    private int tid;
}
