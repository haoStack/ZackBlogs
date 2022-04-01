package cn.rmonkey.service.impl;

import cn.rmonkey.entity.LoginUser;
import cn.rmonkey.entity.UserEntity;
import cn.rmonkey.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Zack
 * @Description
 * @date 2022/4/1 11:06
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void login(UserEntity userEntity) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userEntity.getNickName(),userEntity.getPassword());
        //获取AuthenticationManager,配置类注入 进行authenticate用户认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //认证通过，userid生成jwt
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        String userId =  loginUser.getUserEntity().getId().toString();
        //完整信息存入redis
    }

    @Override
    public void logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authenticationToken.getPrincipal();
        principal.getUserEntity().getId()
        //删除redis中值
    }
}
