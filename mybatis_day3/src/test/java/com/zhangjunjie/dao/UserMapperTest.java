package com.zhangjunjie.dao;

import com.zhangjunjie.pojo.User;
import com.zhangjunjie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void test() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void testLog4J() {
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }

    @Test
    public void testLIMIT() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByLimit = mapper.getUserByLimit(0, 2);
        System.out.println(userByLimit.toString());
        sqlSession.close();
    }

    @Test
    public void testUserAll() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAll = mapper.getUserAll();
        System.out.println(userAll.toString());
        sqlSession.close();
    }
}
