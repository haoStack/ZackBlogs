package cn.rmonkey.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/xhBlogs")
public class Controller {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
