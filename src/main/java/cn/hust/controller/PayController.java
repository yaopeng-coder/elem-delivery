package cn.hust.controller;

import cn.hust.dto.OrderDTO;
import cn.hust.enums.ResultEnum;
import cn.hust.exception.SellException;
import cn.hust.service.OrderService;
import cn.hust.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 20:36
 **/
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;


    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                                Map<String,Object> map)throws IOException{
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付
       PayResponse payResponse  = payService.create(orderDTO);
        map.put("payResponse",payResponse);
        String decode = URLDecoder.decode(returnUrl,"UTF-8");
        map.put("returnUrl",decode );
        return new ModelAndView("pay/create", map);
    }

    //接收微信异步通知
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){

        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }




}
