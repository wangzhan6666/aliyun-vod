package com.sise.wangzhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AliyunVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliyunVodApplication.class, args);
    }

}
