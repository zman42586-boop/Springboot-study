package com.zhangjunjie.dao;

import com.zhangjunjie.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据ID查询用户
    @Select("select * from mybatis.user where id = #{id}")
    User getUserById(@Param("id")int id);

    List<User> getUserByLimit(int startindex,int pagesize);

    @Select("select * from mybatis.user")
    List<User> getUserAll();
}
