package com.uwjx.wechat.lite.server;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 22:17
 */
@Slf4j
public class Testing {

    @Test
    public void run(){
        String a = null;
        log.warn("@@@@@@");
        try {
            assert a != null : "111";
            log.warn("--------");
        }catch (Exception e){
            e.printStackTrace();
        }
        log.warn("22222222222");
    }
}
