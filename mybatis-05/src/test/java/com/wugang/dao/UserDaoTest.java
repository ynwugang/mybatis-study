package com.wugang.dao;


import com.wugang.pojo.User;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/12 16:05
 */
public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUser();
        for (User user : userList) {
            System.out.println(user);

        }
        sqlSession.close();
    }

    @Test
    public void tsetGetUserByID() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserByID(3);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void tsetAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        int i = userDao.addUser(new User(99, "9999", "123456"));
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void tsetUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        int i = userDao.updateUser(new User(99, "小红", "123456"));
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void tsetDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        int i = userDao.deleteUser(99);
        System.out.println(i);
        sqlSession.close();
    }
}
