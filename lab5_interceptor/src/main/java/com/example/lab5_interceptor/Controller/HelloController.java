package com.example.lab5_interceptor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月09日 1:49 下午
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "hello";
    }
}
