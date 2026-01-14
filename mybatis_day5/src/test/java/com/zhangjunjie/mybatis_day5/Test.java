package com.zhangjunjie.mybatis_day5;

import com.zhangjunjie.dao.BlogMapper;
import com.zhangjunjie.pojo.Blog;
import com.zhangjunjie.utils.IDutils;
import com.zhangjunjie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            // 1) Mybatis如此简单
            Blog blog1 = new Blog();
            blog1.setId(IDutils.getID());
            blog1.setTitle("Mybatis如此简单");
            blog1.setAuthor("狂神说");
            blog1.setCreateTime(new Date());
            blog1.setViews(9999);
            mapper.addBlog(blog1);

            // 2) Java如此简单
            Blog blog2 = new Blog();
            blog2.setId(IDutils.getID());
            blog2.setTitle("Java如此简单");
            blog2.setAuthor("狂神说");
            blog2.setCreateTime(new Date());
            blog2.setViews(1000);
            mapper.addBlog(blog2);

            // 3) Spring如此简单
            Blog blog3 = new Blog();
            blog3.setId(IDutils.getID());
            blog3.setTitle("Spring如此简单");
            blog3.setAuthor("狂神说");
            blog3.setCreateTime(new Date());
            blog3.setViews(9999);
            mapper.addBlog(blog3);

            // 4) 微服务如此简单
            Blog blog4 = new Blog();
            blog4.setId(IDutils.getID());
            blog4.setTitle("微服务如此简单");
            blog4.setAuthor("狂神说");
            blog4.setCreateTime(new Date());
            blog4.setViews(9999);
            mapper.addBlog(blog4);

            sqlSession.commit(); // ✅ 一次性提交
        } finally {
            sqlSession.close();
        }
    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title", "Java如此简单");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (int i = 0; i < blogs.size(); i++) {
            System.out.println(blogs.get(i));
        }
    }
}
