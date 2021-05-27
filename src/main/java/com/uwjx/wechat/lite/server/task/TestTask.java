package com.uwjx.wechat.lite.server.task;

import com.google.gson.Gson;
import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.service.impl.RedisService;
import com.uwjx.wechat.lite.server.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 12:03
 */
//@Component
@Slf4j
public class TestTask {

    @Autowired
    RedisService redisService;

    @Scheduled(initialDelay = 1000 * 2 , fixedRate = 1000 * 60 * 60 * 2)
    public void run(){
        log.warn("执行 TestTask 刷新任务");
        redisService.set("name" , "wanghuan");
        log.warn("结果:{}" , redisService.get("name"));

        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token("aaaaaaaaaaaaa");
//        accessToken.setCode("code....");
        accessToken.setErrcode(1);
        accessToken.setErrmsg("msgggg");
        String jsonStr = GsonUtil.toJsonString(accessToken);
        redisService.set("json" , jsonStr);

        String jsonStrRedis = redisService.get("json");

        log.warn("jsonStrRedis 结果:{}" , jsonStrRedis);
        Gson gson = new Gson();
        AccessToken accessToken2 = gson.fromJson(jsonStrRedis , AccessToken.class);
        log.warn("accessToken2 结果:{}" , GsonUtil.toJsonString(accessToken2));
    }
}
