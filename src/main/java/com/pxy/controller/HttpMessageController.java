package com.pxy.controller;

import com.pxy.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 2023/5/31
 **/
@Controller
public class HttpMessageController {
    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) throws UnsupportedEncodingException {
        System.out.println("requestBody :" + URLDecoder.decode(requestBody, "UTF-8"));
        return "success";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) throws UnsupportedEncodingException {
        System.out.println("请求头:" + requestEntity.getHeaders());
        System.out.println("请求体" + URLDecoder.decode(requestEntity.getBody(), "UTF-8"));
        return "success";
    }
    @GetMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        //把”hello，response“作为响应体相应到浏览器中
        response.getWriter().print("hello,response");
    }

    @ResponseBody
    @RequestMapping("/testResponseBody")
    public String testResponseBody(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testResponseUser")
    public User testResponseUser(){
        User user = new User("张三", "123456", 01);
        return user;
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "hello,axios";
    }
}
