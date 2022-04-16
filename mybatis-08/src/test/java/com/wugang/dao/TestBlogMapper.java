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
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("张三");
        blog.setCreateTime(new Date());
        blog.setViews(111);

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java");
        blog.setViews(222);

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        blog.setViews(333);

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务");
        blog.setViews(222);

        blogMapper.addBlog(blog);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testQueryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "Mybatis");
        map.put("author", "张三");

        List<Blog> blogs = blogMapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "Mybatis");
//        map.put("author", "张三");
        map.put("views", 222);

        List<Blog> blogs = blogMapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testUpdateBlogSet(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "李四-学微服务");
        map.put("author", "李-四");
        map.put("id", "a38ebd5057d042caac0ec17834b84502");

        int i = blogMapper.updateBlogSet(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAddBlogUseForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        List<Blog> blogList = new ArrayList<Blog>();

        Blog blog;
        for (int i = 0; i < 1000; i++){
            blog = new Blog();
            blog.setId(IDUtils.getId());
            blog.setTitle("批量插入" + i);
            blog.setAuthor("张三");
            blog.setCreateTime(new Date());
            blog.setViews(999);

            blogList.add(blog);
        }

        map.put("blogList", blogList);

        long startTime = System.currentTimeMillis();

        blogMapper.addBlogUseForeach(map);

        long endTime = System.currentTimeMillis();

        System.out.println("使用foreach执行时间：" + (endTime - startTime));

//        List<Blog> blogList1 = new ArrayList<Blog>();
//
//        for (int i = 0; i < 1000; i++){
//            blog = new Blog();
//            blog.setId(IDUtils.getId());
//            blog.setTitle("批量插入" + i);
//            blog.setAuthor("张三");
//            blog.setCreateTime(new Date());
//            blog.setViews(999);
//
//            blogList1.add(blog);
//        }
//
//        long startTime1 = System.currentTimeMillis();
//
//        for (Blog blog1 : blogList1) {
//
//            blogMapper.addBlog(blog1);
//        }
//
//        long endTime1 = System.currentTimeMillis();
//
//        System.out.println("使用Java遍历执行时间：" + (endTime1 - startTime1));

        sqlSession.commit();

        sqlSession.close();
    }
}
