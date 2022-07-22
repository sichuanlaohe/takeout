package com.he.takeout.controller;

import com.he.takeout.common.R;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${takeout.path}")
    String basePath;
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file)  {
        String originalFilename = file.getOriginalFilename();
        String suffix=originalFilename.substring(originalFilename.indexOf("."));
        String fileName= UUID.randomUUID().toString()+suffix;
        try {
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response)  {
        try {
            FileInputStream fileInputStream=new FileInputStream(new File(basePath+name));
            ServletOutputStream servletOutputStream=response.getOutputStream();
            response.setContentType("imag/jpeg");
            byte[] bytes=new byte[1024];
            int len=0;
            while((len=fileInputStream.read(bytes))!=-1){
                servletOutputStream.write(bytes,0,len);
                servletOutputStream.flush();
            }
            fileInputStream.close();
            servletOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
