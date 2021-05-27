package com.uwjx.wechat.lite.server.retrofit;

import ch.qos.logback.core.util.TimeUtil;
import com.google.gson.Gson;
import com.uwjx.wechat.lite.server.common.Constants;
import com.uwjx.wechat.lite.server.domain.AccessToken;
import com.uwjx.wechat.lite.server.retrofit.api.AccessTokenApi;
import com.uwjx.wechat.lite.server.service.impl.RedisService;
import com.uwjx.wechat.lite.server.util.DateUtil;
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
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 17:59
 */
@Slf4j
@Service
public class GetAccessTokenService extends BaseRetrofitService {

    @Value("${wechat.lite.appId}")
    String appId;
    @Value("${wechat.lite.secret}")
    String appSecret;
    @Autowired
    RedisService redisService;

    public void refreshAccessToken() {
        AccessTokenApi service = retrofit.create(AccessTokenApi.class);
        Call<AccessToken> repos = service.getToken("client_credential", appId, appSecret);
        try {
            Response<AccessToken> response = repos.execute();
            log.warn("结果 body :{}", GsonUtil.toJsonString(response.body()));
            AccessToken accessToken = response.body();
            accessToken.setExpires_in(DateUtil.currentTimeInMillis() + accessToken.getExpires_in() * 1000);
            redisService.set(Constants.ACCESS_TOKEN_REDIS_KEY, GsonUtil.toJsonString(accessToken));
            redisService.expire(Constants.ACCESS_TOKEN_REDIS_KEY, Constants.ACCESS_TOKEN_EXPIRE_TIME);
            log.warn("结果 accessToken :{}", GsonUtil.toJsonString(accessToken));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccessToken getAccessToken() {
        boolean isHasKey = redisService.hasKey(Constants.ACCESS_TOKEN_REDIS_KEY);
        if (isHasKey) {
            String redisStr = redisService.get(Constants.ACCESS_TOKEN_REDIS_KEY);
            if (StringUtils.hasLength(redisStr)) {
                Gson gson = new Gson();
                AccessToken accessToken = gson.fromJson(redisStr, AccessToken.class);
                if (!ObjectUtils.isEmpty(accessToken)) {
                    return accessToken;
                }
            }
        }
        return null;
    }

    public boolean isTokenExpire(AccessToken accessToken) {
        if (ObjectUtils.isEmpty(accessToken)) {
            return true;
        }
        long expireAt = accessToken.getExpires_in();
        log.warn("currentTimeMillis : {}", DateUtil.currentTimeInMillis());
        log.warn("expireAt : {}", expireAt);
        return expireAt <= DateUtil.currentTimeInMillis();
    }

}
