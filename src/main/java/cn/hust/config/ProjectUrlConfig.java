package cn.hust.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 12:58
 **/
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权url
     */

    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */

    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */

    public String sell;
}
