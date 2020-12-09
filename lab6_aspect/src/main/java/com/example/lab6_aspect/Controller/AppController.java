package com.example.lab6_aspect.Controller;

import com.example.lab6_aspect.annotation.AppLock;
import com.example.lab6_aspect.vo.AppInfoVo;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月09日 1:49 下午
 */
@RestController
@RequestMapping("app")
public class AppController {

    @GetMapping
    public String sayHello() {
        return "app hello";
    }

    @PostMapping("/start")
    @AppLock
    public String appLock(@RequestBody() AppInfoVo appInfoVo) {
        return "app start success";
    }
}
