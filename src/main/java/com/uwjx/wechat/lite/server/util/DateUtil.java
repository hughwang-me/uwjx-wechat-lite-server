package com.uwjx.wechat.lite.server.util;

import java.util.Calendar;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/27 16:05
 */
public class DateUtil {

    public static long currentTimeInMillis(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }
}
