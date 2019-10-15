package cn.hust.hander;

import cn.hust.VO.ResultVO;
import cn.hust.exception.SellException;
import cn.hust.exception.SellerAuthorizeException;
import cn.hust.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    /**
     * 注意这里的注解@responseStatus,改变返回的状态码信息，否则返回的状态码为200
     * @param
     * @return
     */
   @ExceptionHandler(value = SellException.class)
   @ResponseStatus(value = HttpStatus.FORBIDDEN)
   @ResponseBody
    public ResultVO handlerSellerException(SellException e){
       return ResultVOUtil.error(e.getCode(),e.getMessage());
   }

}
