package cn.rmonkey.web.controller;

import cn.rmonkey.entity.ResponseResult;
import cn.rmonkey.entity.UserEntity;
import cn.rmonkey.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zack
 * @Description
 * @date 2022/4/1 11:03
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody UserEntity userEntity) {
       //登录
        System.out.println("hello");
        System.out.println(userEntity);
        return loginService.login(userEntity);

    }
    @RequestMapping("/user/logout")
    public void logout() {
        loginService.logout();
    }
}
