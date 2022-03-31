package cn.rmonkey.service;

import cn.rmonkey.entity.UserEntity;

import java.util.List;

/**
 * @author Zack
 * @Description
 * @date 2022/3/31 23:24
 */
public interface UserService {
    List<UserEntity> userList();
}
