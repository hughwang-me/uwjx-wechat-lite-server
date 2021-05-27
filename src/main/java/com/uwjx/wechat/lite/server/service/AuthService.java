package com.uwjx.wechat.lite.server.service;

import com.uwjx.wechat.lite.server.domain.SessionKey;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/25 16:38
 */
public interface AuthService {

    SessionKey codeToSession(SessionKey sessionKey);
}
