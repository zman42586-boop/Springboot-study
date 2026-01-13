package com.zhangjunjie.mybatis_day4;

import com.zhangjunjie.dao.StudentMapper;
import com.zhangjunjie.dao.TeacherMapper;
import com.zhangjunjie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class testMapper {
    @Test
    public void testMapperIfOrNotRight() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher(1));
        sqlSession.close();w
    }
}
