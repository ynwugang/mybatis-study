package com.wugang.dao;

import com.wugang.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author wugang
 * @date 2022/4/16 14:59
 */
public interface BlogMapper {
    /**
     * 插入blog数据
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 查询使用if标签
     * @param map
     * @return
     */
    List<Blog> queryBlogIF(Map<String, Object> map);

    /**
     * 查询使用choose标签
     * @param map
     * @return
     */
    List<Blog> queryBlogChoose(Map<String, Object> map);

    /**
     * 更新；使用set标签
     * @param map
     * @return
     */
    int updateBlogSet(Map map);

    /**
     * 插入，使用foreach
     * @param map
     * @return
     */
    int addBlogUseForeach(Map map);
}
