package com.wugang.dao;

import com.wugang.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author wugang
 * @date 2022/4/12 16:00
 */
public interface UserDao {
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
     * 插入一个user，使用Map
     *
     * @param map
     * @return
     */
    int addUser2(Map<String, Object> map);

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
