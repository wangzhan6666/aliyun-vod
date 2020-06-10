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

        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantPropertiesUtil.KEY_ID, ConstantPropertiesUtil.KEY_SCRET);
            // 删除视频的request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 向request中设置id
            request.setVideoIds(id);
            // 调用初始化对象的方法实现删除
            client.getAcsResponse(request);

            return "删除成功";
        }catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

}
