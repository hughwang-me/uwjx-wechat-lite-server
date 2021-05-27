package com.uwjx.wechat.lite.server.retrofit.api;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/27 13:51
 */
public interface BaseApi {

    String BASE_URL = "https://api.weixin.qq.com";

    String GET_ACCESS_TOKEN = "/cgi-bin/token";

    String JS_CODE_TO_SESSION = "/sns/jscode2session";

}
