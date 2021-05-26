package com.uwjx.wechat.lite.server.task;

import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.retrofit.GetAccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 12:03
 */
@Component
@Slf4j
public class AccessTokenTask {

    @Autowired
    GetAccessTokenService getAccessTokenService;

    @Scheduled(initialDelay = 1000 * 2 , fixedRate = 1000 * 60 * 60 * 2)
    public void run(){
        log.warn("执行 AccessToken 刷新任务");
        AccessToken accessToken = getAccessTokenService.getAccessToken();
        if(getAccessTokenService.isTokenExpire(accessToken)){
            log.warn("刷新Token");
            getAccessTokenService.refreshAccessToken();
        }
    }
}
