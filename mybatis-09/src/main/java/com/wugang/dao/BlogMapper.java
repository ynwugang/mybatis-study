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
     * 查询
     * @param id
     * @return
     */
    Blog queryBlog(String id);

    /**
     * 根据ID更新blog数据
     * @param blog
     * @return
     */
    int updateBlogByID(Blog blog);
}
