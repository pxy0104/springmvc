package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 2023/5/24
 **/

@Controller
//@RequestMapping("/test")
public class TestRequestMapping {
    @RequestMapping(value = {"/hello"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"id", "name"},
            headers = "referer")
    public String test() {
        return "success";
    }

    @RequestMapping("/test/rest/{id}/{name}")
    public String rest(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        return "success";
    }
}
