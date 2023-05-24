package com.pxy.controller;

import com.pxy.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 2023/5/24
 **/

@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest req) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + '\n' + "password:" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String cookie) {
        System.out.println("username:" + username + '\n' + "password:" + password);
        System.out.println("Referer :" + referer);
        System.out.println("cookie :" + cookie);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
