package com.uwjx.wechat.lite.server.retrofit.api;

import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.domain.SessionKey;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 17:53
 */
public interface SessionKeyApi extends BaseApi {

    //GET https://api.weixin.qq.com/sns/jscode2session
    // ?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    @GET(JS_CODE_TO_SESSION)
    Call<SessionKey> getSessionKey(
            @Query("js_code") String js_code,
            @Query("grant_type") String grant_type,
            @Query("appId") String appId,
            @Query("secret") String secret);
}
