package cn.rmonkey.mapper;

import cn.rmonkey.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Zack
 * @Description
 * @date 2022/3/31 23:19
 */
@SpringBootTest ()
public class MyTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testt() {
        List<UserEntity> userEntities = userMapper.selectList(null);
        System.out.println(userEntities.toString());

    }
}
