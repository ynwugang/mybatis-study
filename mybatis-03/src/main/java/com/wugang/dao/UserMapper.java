package com.wugang.dao;

import com.wugang.pojo.User;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/12 16:00
 */
public interface UserMapper {
    /**
     * 根据ID查询用户
     *
     * @param id 用户id
     * @return
     */
    User getUserById(int id);
}
