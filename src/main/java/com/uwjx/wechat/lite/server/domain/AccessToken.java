package com.uwjx.wechat.lite.server.domain;

import lombok.Data;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/25 17:08
 */
@Data
public class AccessToken {

    /**
     * {"access_token":"ACCESS_TOKEN","expires_in":7200}
     * {"errcode":40013,"errmsg":"invalid appid"}
     */
    /**
     * 18:26:29.476 [main] WARN com.uwjx.wechat.lite.server.retrofit.GetAccessTokenService - 结果:
     * {"access_token":"45_C7kjRyC4qhBQD-bHlZ3t5f353-dYsnBRx56iJrjGD6V
     * GWMsLoB8e0CIbDpAOhQhqJHHcKjES3eOxDE0Z9iwM3Wx6Zk1yT8rsyCjBFWx_ZFsI
     * UeRcwSmuLgPmdeEcuqlLbPGsoNGS6yZrYbiXGLRiAHAAFL",
     * "expires_in":7200,
     * "errcode":0}
     */



    private String access_token;
    private long expires_in;
    private int errcode;
    private String errmsg;
}
