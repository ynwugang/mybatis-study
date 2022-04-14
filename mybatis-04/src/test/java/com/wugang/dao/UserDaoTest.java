package com.wugang.dao;


import com.wugang.pojo.User;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author wugang
 * @date 2022/4/12 16:05
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(4);

        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info信息！");
        logger.debug("debug信息！");
        logger.error("error信息！");
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = userMapper.getUserByLimit(map);

        for (User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testGetUserByRowbounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //rowbounds 实现
        RowBounds rowBounds = new RowBounds(0, 2);

        //通过Java代码实现分页
        List<User> userList = sqlSession.selectList("com.wugang.dao.UserMapper.getUserByRowbounds", null, rowBounds);

        for (User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
