package com.taozi.wechat.common.utils.wxpush;

import com.alibaba.fastjson.JSONObject;
import com.taozi.wechat.common.utils.HttpUtils;
import com.taozi.wechat.common.utils.wxpush.vo.WxPushVo;

/**
 * 微信公众号推送utils
 *
 * @author taozi - 2021年6月29日, 029 - 10:52:01
 */
public class WxPushUtils {

    /**
     * 发送信息
     *
     * @param wxPushVo
     * @return boolean
     */
    public static boolean sendWxMsg2User(WxPushVo wxPushVo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", wxPushVo.getOpenid());
        jsonObject.put("template_id", wxPushVo.getTemplateId());
        jsonObject.put("data", wxPushVo.getData());
        System.out.println("发送json： " + jsonObject.toJSONString());
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + wxPushVo.getAccessToken();
        String sendPostResultT = HttpUtils.sendPost(url, jsonObject.toJSONString());
        System.out.println("接收json： " + sendPostResultT);
        JSONObject sendPostResult = JSONObject.parseObject(sendPostResultT);
        return sendPostResult.getInteger("errcode") == 0;
    }
}
