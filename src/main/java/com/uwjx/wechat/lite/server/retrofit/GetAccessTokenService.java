package com.uwjx.wechat.lite.server.retrofit;

import com.google.gson.Gson;
import com.uwjx.wechat.lite.server.common.Constants;
import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.retrofit.api.WechatLiteAccessTokenApi;
import com.uwjx.wechat.lite.server.service.impl.RedisService;
import com.uwjx.wechat.lite.server.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 17:59
 */
@Slf4j
@Service
public class GetAccessTokenService {

    @Value("${wechat.lite.appId}")
    String appId;
    @Value("${wechat.lite.secret}")
    String appSecret;
    @Autowired
    RedisService redisService;

    public void refreshAccessToken() {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl("https://api.weixin.qq.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WechatLiteAccessTokenApi service = retrofitClient.create(WechatLiteAccessTokenApi.class);
        Call<AccessToken> repos = service.getToken("client_credential", appId, appSecret);
        try {
            Response<AccessToken> response = repos.execute();
            AccessToken accessToken = response.body();
            accessToken.setExpires_in(System.currentTimeMillis() + accessToken.getExpires_in());
            redisService.set(Constants.ACCESS_TOKEN_REDIS_KEY , GsonUtil.toJsonString(accessToken));
            log.warn("结果:{}", GsonUtil.toJsonString(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccessToken getAccessToken(){
        boolean isHasKey = redisService.hasKey(Constants.ACCESS_TOKEN_REDIS_KEY);
        if(isHasKey){
            String redisStr = redisService.get(Constants.ACCESS_TOKEN_REDIS_KEY);
            if(StringUtils.hasLength(redisStr)){
                Gson gson = new Gson();
                AccessToken accessToken = gson.fromJson(redisStr , AccessToken.class);
                if(!ObjectUtils.isEmpty(accessToken)){
                    return accessToken;
                }
            }
        }
        return null;
    }

    public boolean isTokenExpire(AccessToken accessToken){
        if(ObjectUtils.isEmpty(accessToken)){
            return true;
        }
        long expireAt =  accessToken.getExpires_in();
        //1622040499053
        //1622040533626
        log.warn("currentTimeMillis : {}" , System.currentTimeMillis());
        log.warn("expireAt : {}" , expireAt);
        return expireAt <= System.currentTimeMillis();
    }
}
