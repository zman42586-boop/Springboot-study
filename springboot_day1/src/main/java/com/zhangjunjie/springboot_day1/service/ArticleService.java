package com.zhangjunjie.springboot_day1.service;

import com.zhangjunjie.springboot_day1.pojo.Article;
import com.zhangjunjie.springboot_day1.pojo.PageBean;
import org.springframework.stereotype.Service;

public interface ArticleService {
    //新增文章
    void add(Article article);
    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
