package com.example.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

    @Bean
    public Helper helper(){
        return new Helper();
    }
}
