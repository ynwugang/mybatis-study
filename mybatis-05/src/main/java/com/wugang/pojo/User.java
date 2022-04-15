package com.wugang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data：无参构造、get、set、toString、equal
 * AllArgsConstructor：有参构造
 * NoArgsConstructor：无参构造
 * @author wugang
 * @date 2022/4/12 15:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
