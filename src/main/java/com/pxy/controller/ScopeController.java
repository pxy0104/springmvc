package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 2023/5/25
 **/
@Controller
public class ScopeController {
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest req) {
        req.setAttribute("username", "张三");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testRequestByModelAndView(ModelAndView mav) {
        mav.addObject("ModelAndView", "mav");
        mav.setViewName("success");
        return mav;
    }


    @RequestMapping("/testModel")
    public String testRequestByModel(Model model) {
        model.addAttribute("Model", "success of model");
        return "success";
    }
    @RequestMapping("/testMap")
    public String testRequestByMap(Map<String,Object> map) {
        map.put("Map", "success of map");
        return "success";
    }
    @RequestMapping("/testModelMap")
    public String testRequestByMap(ModelMap modelMap) {
        modelMap.put("ModelMap", "success of modelMap");
        return "success";
    }
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("Session","success of session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplication","success of Application");
        return "success";
    }
}
