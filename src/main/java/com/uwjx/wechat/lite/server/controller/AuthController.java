package com.uwjx.wechat.lite.server.controller;

import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.domain.SessionKey;
import com.uwjx.wechat.lite.server.service.AuthService;
import com.uwjx.wechat.lite.server.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuan
 */
@RestController
@RequestMapping(value = "auth")
@Slf4j
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(value = "code2Session")
    public String code(@RequestBody SessionKey sessionKey){
        log.warn("请求参数:{}" , GsonUtil.toJsonString(sessionKey));
        return GsonUtil.toJsonString(authService.codeToSession(sessionKey));
    }

}
