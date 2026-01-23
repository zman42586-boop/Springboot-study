//package com.zhangjunjie.springboot_day1;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JWTtest {
//    @Test
//    public void test() {
//        // 1. 准备载荷 (Payload)：就是要存入 Token 里的用户信息
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id", "1");
//        claims.put("username", "张三");
//
//        // 2. 生成 Token
//        String token = JWT.create()
//                .withClaim("user", claims) // 把上面的 map 放入 token 中
//                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 3)) // 设置过期时间
//                .sign(Algorithm.HMAC256("itheima")); // 签名（盖章）
//        // 3. 打印生成的 Token
//        System.out.println(token);
//    }
//
//    @Test
//    void parseToken() {
//        // 1. 定义需要校验的 Token 字符串
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTc2ODgyNDQwMX0.rjyk1QPh23JwYEnx6mf6c09pD5bgqbaPMtam103BCW0";
//
//        // 2. 创建校验器 (Verifier)
//        // 注意：这里的 Algorithm 必须与生成 Token 时使用的加密算法和密钥（"itheima"）完全一致
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();
//
//        // 3. 执行校验并获取解密后的 JWT 对象
//        // 如果 Token 已过期或被篡改，这一步会抛出异常
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);
//
//        // 4. 获取 Token 中存放的载荷 (Claims)
//        Map<String, Claim> claims = decodedJWT.getClaims();
//
//        // 5. 提取并打印特定的数据（如之前存入的 "user" 信息）
//        System.out.println(claims.get("user"));
//    }
//}
