package cn.rmonkey.service.impl;

import cn.rmonkey.entity.LoginUser;
import cn.rmonkey.entity.UserEntity;
import cn.rmonkey.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Zack
 * @Description
 * @date 2022/4/1 0:03
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(bCryptPasswordEncoder.matches("1234","$2a$10$dJFdRAN4ipMQrD7KhSBQcuXpI6B74.a0rJtRlmxr96elOMutAcWnu"));
        //查询用户信息
        UserEntity userEntities = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("nick_name",username));
        System.out.println(userEntities);
        if(Objects.isNull(userEntities)) {
            throw new RuntimeException("用户名密码错误");
        }

        //查询用户权限
        List<String> permissions = new ArrayList<>(Arrays.asList("admin","super"));
        //数据封装成userDetails
        return new LoginUser((UserEntity) userEntities,permissions);
    }
}
