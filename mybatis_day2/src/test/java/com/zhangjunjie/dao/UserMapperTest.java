package com.zhangjunjie.dao;

import com.zhangjunjie.dao.UserMapper;
import com.zhangjunjie.pojo.User;
import com.zhangjunjie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    //对于增删改查中的，增改删这三个业务，都需要提交事务，这是mybatis的机制
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(7, "zhangjunjie", "zhangjunjie"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6, "zhangjunjie", "zhangjunjieUpdate"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
