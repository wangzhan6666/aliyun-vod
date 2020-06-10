package com.sise.wangzhan.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Classname VodService
 * @Description TODO
 * @Date 2020/6/10 11:21
 * @Created by wangzhan
 */
public interface VodService {
    // 1 阿里云视频上传
    String upload(MultipartFile file);
    // 2 根据视频id删除阿里云视频
    String removeAlyVideo(String id);
    // 3 根据多个视频id删除阿里云视频
    String removeAlyMoreVideo(List idList);
    // 4 根据视频id获取视频凭证
    String getPlayAuth(String id);
}
