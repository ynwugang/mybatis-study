package com.wugang.dao;

import com.wugang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wugang
 * @date 2022/4/15 20:08
 */
public interface TeacherMapper {

//    @Select("select * from teacher where id = #{tid}")
//    Teacher getTeacher(@Param("tid") int id);

    /**
     * 获取指定老师及其下所有学生的信息
     * @param id
     * @return
     */
    Teacher getTeacher(int id);

    /**
     * 获取指定老师及其下所有学生的信息
     * @param id
     * @return
     */
    Teacher getTeacher2(int id);
}
