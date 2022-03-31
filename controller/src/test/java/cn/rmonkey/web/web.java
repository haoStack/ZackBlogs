package cn.rmonkey.web;

import cn.rmonkey.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zack
 * @Description
 * @date 2022/3/31 23:03
 */
@SpringBootTest()
public class web {
    @Autowired
    UserService userService;

    @Test
    public void MyTest() {
        System.out.println(userService.userList());
    }
}
