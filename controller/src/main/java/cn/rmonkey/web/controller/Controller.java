package cn.rmonkey.web.controller;

import cn.rmonkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        System.out.println(userService.userList());
        return "hello";
    }
}
