package com.wugang.dao;

import com.wugang.pojo.Teacher;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wugang
 * @date 2022/4/15 20:13
 */
public class TsetTeacherMapper {

    @Test
    public void testGetTeacher (){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = teacherMapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();
    }
}
