package cn.hust.controller;

import cn.hust.enums.ResultEnum;
import cn.hust.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 09:11
 **/
@Controller
@Slf4j
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    /**
     * 授权大致流程：用户访问域名，前端根据cookie中有没有oopenid来判断是否需要经过授权流程，
     * 若没有则重定向到后台授权接口访问（wechat/authorize?returnUrl），经历两次重定向，获取到openid,最后再次返回前端列表（此时cookie中有openid）
     * @param returnUrl
     * @return
     */

    //个人理解,授权部分第一个链接，需要设置appid,scope，secret,跳转该链接
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        String url = "http://thexx.natapp1.cc/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    //个人理解，授权部分第二个链接，通过上述链接能返回code的值，用户获取到该code值即可获的AccessToken值，通过该值可以取出openid
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权{}】",e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
        return "redirect:" + returnUrl + "?openid=" + openId;
    }




}
