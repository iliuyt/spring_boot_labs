package com.example.lab3_mybatis_plus_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.lab3_mybatis_plus_mysql.mapper")
public class Lab3MybatisPlusMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3MybatisPlusMysqlApplication.class, args);
    }

}
