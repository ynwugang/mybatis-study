package com.wugang.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author wugang
 * @date 2022/4/16 14:57
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
