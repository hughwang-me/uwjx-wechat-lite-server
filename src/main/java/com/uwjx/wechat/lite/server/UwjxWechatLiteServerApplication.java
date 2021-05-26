package com.uwjx.wechat.lite.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UwjxWechatLiteServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UwjxWechatLiteServerApplication.class, args);
    }

}
