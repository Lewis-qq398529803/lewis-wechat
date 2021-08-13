package com.taozi.wechat.controller;


import com.taozi.wechat.common.utils.wxcommon.AccessTokenUtils;
import com.taozi.wechat.common.utils.wxpush.WxPushUtils;
import com.taozi.wechat.common.utils.wxpush.vo.WxPushVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信公众号推送
 *
 * @author taozi - 2021年7月27日, 027 - 10:04:52
 */
@Controller
@RequestMapping("/WxPush")
public class WeChatPushController {

	@PostMapping("/sendMessage2OpenId")
	public boolean sendMessage2OpenId(@RequestBody WxPushVo wxPushVo) {
		// 参数非空验证
		if (wxPushVo.getOpenid() == null || wxPushVo.getTemplateId() == null || wxPushVo.getCode() == null) {
			return false;
		}

		// 通过code获取token
		String accessToken = AccessTokenUtils.getAccessToken(wxPushVo.getCode());
		String fail = "获取access_token失败";
		String ok = "获取access_token出现异常";
		if (accessToken.equals(fail) || accessToken.equals(ok)) {
			return false;
		}
		wxPushVo.setAccessToken(accessToken);

		return WxPushUtils.sendWxMsg2User(wxPushVo);
	}

}
