package com.uwjx.wechat.lite.server.service.impl;

import com.uwjx.wechat.lite.server.common.WxUrl;
import com.uwjx.wechat.lite.server.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/25 16:40
 */
@Service
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {

    @Value("${wechat.lite.appId}")
    String appId;
    @Value("${wechat.lite.secret}")
    String appSecret;

    @Override
    public void refreshAccessToken() {
        log.warn("开始刷新 AccessToken @@@ ");
        String url = WxUrl.GET_ACCESS_TOKEN +
                "?" +
                "grant_type=client_credential" +
                "&appid=" + appId +
                "&secret=" + appSecret;
        log.warn("url : {}" , url);


    }
}
