package com.pxy.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 2023/6/1
 **/

@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/duck.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=duck.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping("/testUp")
    public String testUp(HttpSession session,@RequestParam("photo") MultipartFile photo) throws IOException {
        String fileName = photo.getOriginalFilename();
        //通过文件名获取文件的后缀名，即拓展名
        String format = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("number:"+fileName.lastIndexOf("."));
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        System.out.println("photoPath"+photoPath);
        File file = new File(photoPath);
        String uuid =UUID.randomUUID().toString();
        fileName = uuid+format;
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
