package com.pxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 2023/5/30
 **/

@Controller
public class UserController {
    /**
     * 使用RESTful风格
     * 查询所有用户信息 /user GET
     * 根据id查询用户信息 /user/1 GET
     * 添加用户信息 /user POST
     * 删除用户信息 /user/1 DELETE
     * 修改用户信息 /user PUT
     */
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息,ID:"+id);
        return "success";
    }
    @PostMapping("/user")
    public String insertUser(@RequestParam("username") String username, @RequestParam("password")String password){
        System.out.println("添加用户信息,username:"+username+",password:"+password);
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(){
        System.out.println("修改用户信息 /user PUT");
        return "success";
    }
}
