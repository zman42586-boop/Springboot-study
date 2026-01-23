package com.zhangjunjie.springboot_day1.controller;

import com.zhangjunjie.springboot_day1.pojo.Result;
import com.zhangjunjie.springboot_day1.pojo.User;
import com.zhangjunjie.springboot_day1.service.UserService;
import com.zhangjunjie.springboot_day1.utils.JwtUtil;
import com.zhangjunjie.springboot_day1.utils.Md5Util;
import com.zhangjunjie.springboot_day1.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password){
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //没有占用，注册
            userService.register(username, password);
            return Result.success("");
        } else {
            //占用
            return Result.error("已经被占用");
        }
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password){
        User login_user = userService.findByUserName(username);
        if (login_user == null) {
            return Result.error("用户名不存在");
        }
        if(Md5Util.getMD5String(password).equals(login_user.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",login_user.getId());
            claims.put("username",login_user.getUsername());
            String token = JwtUtil.genToken(claims);
            //把token放到redis中
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(token,token,1, TimeUnit.HOURS);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization")String token){
        //根据用户名查询用户
//        Map<String, Object> map = JwtUtil.parseToken(token);
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvater(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params,@RequestHeader("Authorization") String token){
        //校验参数
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String rePwd = params.get("rePwd");

        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数");
        }
        //原密码是否正确
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if(!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码填写不正确");
        }
        //确认新密码和确认密码是否正确
        if(!rePwd.equals(newPwd)){
            return Result.error("两次填写的密码不一样");
        }
        //调用service完成参数更新
        userService.updatePwd(newPwd);
        //删除redis中对应的token
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.getOperations().delete(token);
        return Result.success();
    }
}
