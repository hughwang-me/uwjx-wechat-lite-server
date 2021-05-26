package com.uwjx.wechat.lite.server.util;

import com.google.gson.Gson;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/25 17:09
 */
public class GsonUtil {

    public static String toJsonString(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
