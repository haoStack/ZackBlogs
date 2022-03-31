package cn.rmonkey.service;

import cn.rmonkey.entity.UserEntity;
import cn.rmonkey.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zack
 * @Description
 * @date 2022/3/31 23:25
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserEntity> userList() {
        return userMapper.selectList(null);
    }
}
