package com.wugang.dao;

import com.wugang.pojo.User;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/12 16:00
 */
public interface UserMapper {
    /**
     * 获取全部用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据ID查询用户
     *
     * @param id 用户id
     * @return
     */
    User getUserById(int id);

    /**
     * 插入一个user
     *
     * @param user
     * @return
     */
    int addUser(User user);


    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    int deleteUser(int id);
}
