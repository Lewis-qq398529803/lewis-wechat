package com.taozi.wechat.common.utils.wxpush.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 微信公众号模板消息推送vo
 *
 * @author taozi - 2021年6月29日, 029 - 14:32:27
 */
@Data
public class WxPushVo {

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 接收者openid
     */
    private String openid;

    /**
     * data数据
     */
    private JSONObject data;

    /**
     * 微信code
     */
    private String code;

    /**
     * 凭证
     */
    private String accessToken;

    /**
     * 房东名
     */
    private String masterName;

    /**
     * 租客名
     */
    private String tenantName;

    /**
     * 房号
     */
    private String houseNum;

    /**
     * 租约时间
     */
    private String leaseTime;

}
