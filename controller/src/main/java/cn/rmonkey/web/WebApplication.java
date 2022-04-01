package cn.rmonkey.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.rmonkey")
@SpringBootApplication
@MapperScan("cn.rmonkey.mapper")
public class WebApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WebApplication.class, args);
    }
}
