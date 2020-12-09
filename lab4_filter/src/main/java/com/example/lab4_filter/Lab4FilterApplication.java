package com.example.lab4_filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.lab4_filter.ScanFilters")
public class Lab4FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4FilterApplication.class, args);
    }

}
