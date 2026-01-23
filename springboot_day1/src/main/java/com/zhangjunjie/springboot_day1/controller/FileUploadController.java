package com.zhangjunjie.springboot_day1.controller;


import com.zhangjunjie.springboot_day1.pojo.Result;
import com.zhangjunjie.springboot_day1.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> Upload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        String filename  = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("C:\\Users\\Zhangjunjie\\IdeaProjects\\6、SpringBoot3+Vue3全套教程\\02_资料\\04_综合案例资料\\" + filename));
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}