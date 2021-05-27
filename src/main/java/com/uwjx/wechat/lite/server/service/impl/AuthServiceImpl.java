package com.uwjx.wechat.lite.server.service.impl;

import com.uwjx.wechat.lite.server.common.WxUrl;
import com.uwjx.wechat.lite.server.domain.SessionKey;
import com.uwjx.wechat.lite.server.retrofit.WechatTokenService;
import com.uwjx.wechat.lite.server.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/25 16:40
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Value("${wechat.lite.appId}")
    String appId;
    @Value("${wechat.lite.secret}")
    String appSecret;

    @Autowired
    WechatTokenService wechatTokenService;

    @Override
    public SessionKey codeToSession(SessionKey sessionKey) {
        return wechatTokenService.getSessionKey(sessionKey);
    }
}
