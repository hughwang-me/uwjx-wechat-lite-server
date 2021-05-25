package com.uwjx.wechat.lite.server.controller;

import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuan
 */
@RestController
@RequestMapping(value = "access_token")
@Slf4j
public class AccessTokenController {

    @PostMapping(value = "code")
    public String code(@RequestBody AccessToken accessToken){
        log.warn("请求参数:{}" , GsonUtil.toJsonString(accessToken));

        return "";
    }

}
