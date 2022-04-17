package com.wugang.dao;

import com.wugang.pojo.Blog;
import com.wugang.utils.IDUtils;
import com.wugang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wugang
 * @date 2022/4/16 15:12
 */
public class TestBlogMapper {
    @Test
    public void testQueryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = blogMapper.queryBlog("592b316af252422594c392f717f045d6");
        System.out.println(blog);

        //执行更新
        //blogMapper.updateBlogByID(new Blog("a38ebd5057d042caac0ec17834b84502", "张三-微服务", null, null, 0));

        //手动清理sqlSession缓存
        sqlSession.clearCache();

        System.out.println("=========================================================");

        Blog blog1 = blogMapper.queryBlog("592b316af252422594c392f717f045d6");
        System.out.println(blog1);

        sqlSession.close();
    }


    @Test
    public void testQueryBlog1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.queryBlog("592b316af252422594c392f717f045d6");
        System.out.println(blog);

        sqlSession.close();

        System.out.println("=========================================================");

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        BlogMapper blogMapper1 = sqlSession1.getMapper(BlogMapper.class);
        Blog blog1 = blogMapper1.queryBlog("592b316af252422594c392f717f045d6");
        System.out.println(blog1);

        sqlSession1.close();
    }
}
