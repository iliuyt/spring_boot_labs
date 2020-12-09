package com.example.lab2_mybatis_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lab2_mybatis_mysql.mapper")
public class Lab2MybatisMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2MybatisMysqlApplication.class, args);
    }

}
