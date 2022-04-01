package cn.rmonkey.service;

import cn.rmonkey.entity.UserEntity;

/**
 * @author Zack
 * @Description
 * @date 2022/4/1 11:06
 */
public interface LoginService {

    void login(UserEntity userEntity);

    void logout();
}
