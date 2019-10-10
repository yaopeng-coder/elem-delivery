package cn.hust.controller;

import cn.hust.dto.OrderDTO;
import cn.hust.enums.ResultEnum;
import cn.hust.exception.SellException;
import cn.hust.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){

        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

    }

    //发起支付


}
