package com.example.lab1_security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

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
    @GetMapping("/a")
    public String sayHelloa() {
        return "helloa";
    }
    @GetMapping("/b")
    public String sayHellob() {
        return "hellob";
    }
    @GetMapping("/c")
    public String sayHelloc() {
        return "helloc";
    }
    @GetMapping("/d")
    @PermitAll
    public String sayHellod() {
        return "hellod";
    }
    @GetMapping("/e")
    @PreAuthorize("hasAnyRole('admin2')")
    public String sayHelloe() {
        return "helloe";
    }
}
