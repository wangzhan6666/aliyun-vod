package com.sise.wangzhan.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.sise.wangzhan.service.VodService;
import com.sise.wangzhan.utils.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Classname VodServiceImpl
 * @Description TODO
 * @Date 2020/6/10 11:21
 * @Created by wangzhan
 */
@Service
public class VodServiceImpl implements VodService {

    // 1 阿里云视频上传
    // 使用  流式上传接口的方式（https://help.aliyun.com/document_detail/51992.html）中下载SDK
    // 下载下来的SDK中有代码，根据需求自行更改
    @Override
    public String upload(MultipartFile file) {

        try {
            String keyId = ConstantPropertiesUtil.KEY_ID;
            String keyScret = ConstantPropertiesUtil.KEY_SCRET;
            // 视频的原名称
            String fileName = file.getOriginalFilename();
            // 在阿里云中文件显示的名称(去除了文件的后缀名)
            String title = fileName.substring(0, fileName.lastIndexOf("."));
            // 文件流
            InputStream inputStream = file.getInputStream();


            UploadStreamRequest request = new UploadStreamRequest(keyId, keyScret, title, fileName, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
            return videoId;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
