package com.zhangjunjie.springboot_day1.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhangjunjie.springboot_day1.mapper.ArticleMapper;
import com.zhangjunjie.springboot_day1.pojo.Article;
import com.zhangjunjie.springboot_day1.pojo.PageBean;
import com.zhangjunjie.springboot_day1.service.ArticleService;
import com.zhangjunjie.springboot_day1.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        //补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String ,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        Map<String ,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("id");
        List<Article> as = articleMapper.list(id,categoryId,state);
        Page<Article> p = (Page<Article>) as;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
