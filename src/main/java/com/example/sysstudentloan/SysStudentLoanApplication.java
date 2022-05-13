package com.example.sysstudentloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//会自动读取spring.datasource.*属性并自动配置单数据源 配置多数据源要禁用
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
@EnableCaching
@EnableAsync
public class SysStudentLoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysStudentLoanApplication.class, args);
    }

}
