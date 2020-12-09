package com.example.lab7_bean.Controller;

import com.example.lab7_bean.an.AppLock;
import com.example.lab7_bean.config.DefaultMyBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月23日 2:12 下午
 */

@RestController()
public class HelloController {
    @Resource(name = "tt")
    private  DefaultMyBean defaultMyBeanTt;


    @Resource(name = "tm")
    private  DefaultMyBean defaultMyBeanTm;


    @GetMapping("hello")
    public String sayHello() {
        System.out.println(defaultMyBeanTt.getName());
        System.out.println(defaultMyBeanTm.getName());

        return "xxx";
    }

    @PostMapping("data")
    @AppLock
    public String getData(@RequestBody DefaultMyBean defaultMyBean) {
        return defaultMyBean.getName();
    }
}
