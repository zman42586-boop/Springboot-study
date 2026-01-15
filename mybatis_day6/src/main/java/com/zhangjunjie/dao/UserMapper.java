package com.zhangjunjie.dao;

import com.zhangjunjie.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
