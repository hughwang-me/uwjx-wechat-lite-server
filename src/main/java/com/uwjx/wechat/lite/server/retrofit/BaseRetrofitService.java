package com.uwjx.wechat.lite.server.retrofit;

import com.uwjx.wechat.lite.server.retrofit.api.BaseApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/27 16:00
 */
public class BaseRetrofitService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
