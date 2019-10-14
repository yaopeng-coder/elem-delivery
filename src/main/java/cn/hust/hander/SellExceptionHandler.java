package cn.hust.hander;

import cn.hust.exception.SellerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对抛出的异常进行处理
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 16:31
 **/
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(SellerAuthorizeException.class)
   public ModelAndView handlerAuthorizeException(){
       return new ModelAndView("redirect:"+"https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87" +
               "&redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2FoTgZpwWWgaFiFYVr0m3GG2AKNfhM&" +
               "response_type=code&scope=snsapi_login&" +
               "state=http://thexx.natapp1.cc/sell/wechat/qrUserInfo");
   }


}
