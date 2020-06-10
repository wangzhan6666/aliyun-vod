package com.sise.wangzhan.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname VodService
 * @Description TODO
 * @Date 2020/6/10 11:21
 * @Created by wangzhan
 */
public interface VodService {
    // 1 阿里云视频上传
    String upload(MultipartFile file);
}
