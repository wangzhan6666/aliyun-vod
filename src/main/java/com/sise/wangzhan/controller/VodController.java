package com.sise.wangzhan.controller;

import com.sise.wangzhan.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname VodController
 * @Description TODO
 * @Date 2020/6/10 11:21
 * @Created by wangzhan
 */
@RestController
@RequestMapping("/wangzhan/vod")
public class VodController {

    @Autowired
    private VodService vodService;

    // 1 阿里云视频上传
    // 返回上传视频的id值
    @PostMapping("upload")
    public String upload(MultipartFile file) {

        String vidoeId = vodService.upload(file);

        return vidoeId;
    }

}
