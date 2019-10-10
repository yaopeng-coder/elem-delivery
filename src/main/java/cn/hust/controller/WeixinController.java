package cn.hust.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-09 18:55
 **/

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auto(@RequestParam("code") String code){
        log.info("进入auto方法。。。");
        log.info("code={}",code);

        String  url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx514cc4048133e1d6&secret=e5b2b9cc7549136bc6a5622291a09809&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate =  new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response = {}",response);



    }
}
