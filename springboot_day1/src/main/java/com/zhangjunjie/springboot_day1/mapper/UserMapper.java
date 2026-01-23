package com.zhangjunjie.springboot_day1.mapper;

import com.zhangjunjie.springboot_day1.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface UserMapper {
    @Select("SELECT * from big_event.user where username = #{username}")
    User findByUserName(String username);
    @Insert("INSERT INTO big_event.user(username,password,create_time,update_time)"+
            "values (#{username},#{password},now(),now())")
    void add(String username, String password);
    @Update("update big_event.user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id = #{id}")
    void update(User user);
    @Update("update big_event.user set user_pic=#{avatarUrl},update_time=now() where id = #{id}")
    void updateAvatar(String avatarUrl,Integer id);
    @Update("update big_event.user set password=#{md5String},update_time=now() where id = #{id}")
    void updatePwd(String md5String, Integer id);
}
