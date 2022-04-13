package com.wugang.dao;


import com.wugang.pojo.User;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(4);

        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }
}
