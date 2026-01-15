package com.zhangjunjie.mybatis_day6;

import com.zhangjunjie.dao.UserMapper;
import com.zhangjunjie.pojo.User;
import com.zhangjunjie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class myTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user.toString());
        User user2 = mapper.queryUserById(2);
        System.out.println(user2.toString());
        sqlSession.close();
        sqlSession2.close();
    }
}
