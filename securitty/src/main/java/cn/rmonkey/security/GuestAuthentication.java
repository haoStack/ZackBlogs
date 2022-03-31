package cn.rmonkey.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zack
 * @Description 自定义表表单登录验证
 * @date 2022/3/31 15:08
 */
@RequiredArgsConstructor
public class GuestAuthentication extends UsernamePasswordAuthenticationFilter {
    //这里没有用@Autowrited，用构造函数注入
    private final ObjectMapper objectMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken;
        //读取请求体
        try {
            ServletInputStream inputStream = request.getInputStream();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            String username = jsonNode.get("username").textValue();
            String password = jsonNode.get("password").textValue();
            authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BadCredentialsException("没有找到用户名，密码");
        }

        setDetails(request, authenticationToken);
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }
}
