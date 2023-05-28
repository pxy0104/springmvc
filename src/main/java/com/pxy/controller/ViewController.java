package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2023/5/27
 **/
@Controller
public class ViewController {
    @RequestMapping("/testThymeleafView")
    public String testThymeleaf(){
        return "success";
    }
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:testThymeleafView";
    }
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:testThymeleafView";
    }
    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }
}
