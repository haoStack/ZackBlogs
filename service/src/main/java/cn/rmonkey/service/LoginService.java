package cn.rmonkey.service;

import cn.rmonkey.entity.ResponseResult;
import cn.rmonkey.entity.UserEntity;

/**
 * @author Zack
 * @Description
 * @date 2022/4/1 11:06
 */
public interface LoginService {

    ResponseResult login(UserEntity userEntity);

    ResponseResult logout();
}
