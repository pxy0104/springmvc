package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 2023/5/25
 **/
@Controller
public class ScopeController {
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest req) {
        req.setAttribute("username","张三");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testRequestByServletAPI(ModelAndView mav) {
        mav.addObject("ModelAndView","mav");
        mav.setViewName("success");
        return mav;
    }
}
