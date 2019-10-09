package cn.hust.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    }
}
