package com.example.sysstudentloan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的路径
        String[] arr = {"/loginx","/menu","/order/notify_url"};
        registry.addInterceptor(jwtInterceptor()).addPathPatterns("/**").excludePathPatterns(arr);
    }

    /**
     * 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
     * 这是图片的物理路径  "file:/+本地图片的地址"
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//
//        registry.addViewController("/notLogin").setViewName("notLogin");
    }

    /**
     * jwt拦截器
     * */
    @Bean
    public LoginInterceptor jwtInterceptor() {
        return new LoginInterceptor();
    }

    @Autowired
    private Environment environment;

}
