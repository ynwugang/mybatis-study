package com.wugang.dao;

import com.wugang.pojo.User;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wugang
 * @date 2022/4/12 16:05
 */
public class UserDaoTest {
    @Test
    public void test() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        //方法一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        //方式二
//        List<User> userList = sqlSession.selectList("com.wugang.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User us = userDao.getUserById(1);
        System.out.println(us);

        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int i = userDao.addUser(new User(4, "小明", "123456789"));

        //增删改需要提交事物，否则不会生效
        sqlSession.commit();

        System.out.println("插入了" + i + "个user");

        sqlSession.close();;
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int i = userDao.updateUser(new User(1, "小红", "111111"));

        sqlSession.commit();

        System.out.println("更新了" + i + "个user");

        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int i = userDao.deleteUser(1);

        sqlSession.commit();

        System.out.println("删除了" + i + "个user");

        sqlSession.close();
    }

    @Test
    public void testAddUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 5);
        map.put("userName", "map");
        map.put("userPwd", "222333");

        int i = userDao.addUser2(map);

        //增删改需要提交事物，否则不会生效
        sqlSession.commit();

        System.out.println("插入了" + i + "个user");

        sqlSession.close();;
    }
}
