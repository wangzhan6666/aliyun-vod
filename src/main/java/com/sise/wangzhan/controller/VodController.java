package com.sise.wangzhan.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.sise.wangzhan.service.VodService;
import com.sise.wangzhan.utils.ConstantPropertiesUtil;
import com.sise.wangzhan.utils.InitVodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    // 2 根据视频id删除阿里云视频
    @DeleteMapping("removeAlyVideo/{id}")
    public String removeAlyVideo(@PathVariable String id) {

        String info = vodService.removeAlyVideo(id);

        return info;
    }


    // 3 根据多个视频id删除阿里云视频
    @DeleteMapping("removeAlyMoreVideo")
    public String removeAlyMoreVideo(@RequestParam("idList") List<String> idList) {

        String info = vodService.removeAlyMoreVideo(idList);

        return info;
    }

    // 4 根据视频id获取视频凭证
    @GetMapping("getPlayAuth/{id}")
    public String getPlayAuth(@PathVariable String id) {

        String playAuth = vodService.getPlayAuth(id);

        return playAuth;
    }

}
