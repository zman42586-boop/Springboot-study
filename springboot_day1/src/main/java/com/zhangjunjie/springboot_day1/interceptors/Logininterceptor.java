package com.zhangjunjie.springboot_day1.interceptors;

import com.zhangjunjie.springboot_day1.pojo.Result;
import com.zhangjunjie.springboot_day1.utils.JwtUtil;
import com.zhangjunjie.springboot_day1.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class Logininterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            //从redis中获取相同的token
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            String redisToken = stringStringValueOperations.get(token);
            if(redisToken == null) {
                //token失效了
                throw new Exception();
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            //把业务数据存储到threadlocal中去
            ThreadLocalUtil.set(claims);
            //放行
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        ThreadLocalUtil.remove();//防止内存泄露
    }
}


