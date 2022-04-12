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
        //第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        //方法一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //方式二
//        List<User> userList = sqlSession.selectList("com.wugang.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }
}
