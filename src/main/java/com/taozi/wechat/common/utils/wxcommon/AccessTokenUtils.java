package com.taozi.wechat.common.utils.wxcommon;

import com.alibaba.fastjson.JSONObject;
import com.taozi.wechat.common.utils.HttpUtils;
import com.taozi.wechat.config.WxConfig;

/**
 * access_token工具类
 *
 * @author taozi - 2021年7月7日, 007 - 14:21:02
 */
public class AccessTokenUtils {

    public static String getAccessToken(String code) {
        String appid = WxConfig.APPID;
        String secret = WxConfig.APPSECRET;
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String param = "appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        String dataT = HttpUtils.sendGet(url, param);
        JSONObject jsonObject = JSONObject.parseObject(dataT);
        if (jsonObject == null) {
            return "获取access_token出现异常";
        }
        if (jsonObject.get("errcode") != null || jsonObject.get("errcode") == "") {
            System.out.println(jsonObject.toJSONString());
            return "获取access_token失败";
        }
        return jsonObject.getString("access_token");
    }
}
