package com.uwjx.wechat.lite.server.retrofit.api;

import com.uwjx.wechat.lite.server.domain.AccessToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 17:53
 */
public interface WechatLiteAccessTokenApi {

    @GET("/cgi-bin/token")
    Call<AccessToken> getToken(@Query("grant_type") String grant_type ,
                               @Query("appId") String appId ,
                               @Query("secret") String secret );
}
