package com.zhangjunjie.mybatisplus;

import com.zhangjunjie.domain.pojo.User;
import com.zhangjunjie.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired; // 1. 导入自动注入注解
import org.springframework.boot.test.context.SpringBootTest; // 2. 导入测试环境注解

@SpringBootTest // 3. 加上这个，启动 Spring 容器，这样才能用到 Mapper
public class MapperTest {

    @Autowired // 4. 加上这个，Spring 才会帮你把对象“注入”进来，否则它是 null
    private UserMapper userMapper;

    @Test
    void SampleTest() { // 5. 加上括号 ()，修复语法错误
        User user = userMapper.selectById(1); // 建议加上 L 表示 Long 类型
        System.out.println(user);
    }
}