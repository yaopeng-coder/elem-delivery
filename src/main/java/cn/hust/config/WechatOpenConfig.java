package cn.hust.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 11:14
 **/
@Component
public class WechatOpenConfig {

    @Autowired
    WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;
    }

    @Bean
    public WxMpConfigStorage wxOpenConfigStorage(){

        WxMpInMemoryConfigStorage wxOpenInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxOpenInMemoryConfigStorage.setAppId(accountConfig.getOpenAppId());
        wxOpenInMemoryConfigStorage.setSecret(accountConfig.getOpenAppSecret());
        return wxOpenInMemoryConfigStorage;

    }
}
