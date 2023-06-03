package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2023/6/2
 **/
@Controller
public class TestInterceptor {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("controller执行中");
        return "success";
    }
    @RequestMapping("/testException")
    public String testError(){
        System.out.println(1/0);
        return "success";
    }
}
