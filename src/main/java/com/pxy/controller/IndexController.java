package com.pxy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2023/5/23
 **/

@Controller
public class IndexController {

//    @GetMapping("/")
//    public String portal() {
//        return "index";
//    }

    @GetMapping(value = "/index")
    public String index() {
        return "success";
    }
}
