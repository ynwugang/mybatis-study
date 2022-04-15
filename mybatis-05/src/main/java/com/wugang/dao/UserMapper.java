package com.wugang.dao;

import com.wugang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author wugang
 * @date 2022/4/12 16:00
 */
public interface UserMapper {
    /**
     * 查询用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> getUser();

    /**
     * 根据id查询用户
     * 使用注解时，需要在基本类型参数（或String类型）前面加上@Param("..")注解
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser (User user);

    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
