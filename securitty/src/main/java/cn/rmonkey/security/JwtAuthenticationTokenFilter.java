package cn.rmonkey.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zack
 * @Description定义jwt认证过滤器
 * @date 2022/4/1 12:04
 */
//请求只经过这个过滤器一次
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        filterChain.doFilter(request,response);
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行,后面或判断是否认证
            filterChain.doFilter(request, response);
            return;
        }
        //解析token

        //redis中获取用户信息，权限信息

        //存入SecurityContextHolder
        //userdetails,authorities
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken();
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        //放行
        filterChain.doFilter(request,response);
    }

}
