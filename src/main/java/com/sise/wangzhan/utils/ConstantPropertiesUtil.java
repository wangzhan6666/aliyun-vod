package com.sise.wangzhan.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname ConstantPropertiesUtil
 * @Description TODO
 * @Date 2020/6/3 16:25
 * @Created by wangzhan
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${aliyun.vod.file.keyid}")
    private String keyid;

    @Value("${aliyun.vod.file.keysecret}")
    private String keyscret;


    public static String KEY_ID;
    public static String KEY_SCRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = keyid;
        KEY_SCRET = keyscret;
    }
}
