package cn.hust.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 08:41
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;


    private String openAppId;

    private String openAppSecret;

    //商户号
    private String mchId;

    //商户密钥
    private String mchKey;

    //商户证书途径
    private String keyPath;

    //微信支付异步通知地址
    private String notifyUrl;
}
