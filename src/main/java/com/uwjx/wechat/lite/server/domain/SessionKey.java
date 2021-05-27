package com.uwjx.wechat.lite.server.domain;

import lombok.Data;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/27 17:05
 */
@Data
public class SessionKey {

    private String code;
    private String openid;
    private String session_key;
    private String unionid;

    private int errcode;
    private String errmsg;
}
