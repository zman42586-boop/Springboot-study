package com.zhangjunjie.springboot_day1.mapper;

import com.zhangjunjie.springboot_day1.pojo.Category;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO big_event.category(category_name,category_alias,create_user,create_time,update_time)"+
            "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);
    @Select("SELECT * from big_event.category where create_user = #{userid}")
    List<Category> list(Integer userid);
    @Select("SELECT * from big_event.category where id = #{id}")
    Category findById(Integer id);
    @Update("update big_event.category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id = #{id}")
    void update(Category category);
    @Delete("DELETE FROM big_event.category where id = #{id}")
    void deleteById(Integer id);
}
