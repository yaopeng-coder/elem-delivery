package cn.hust.controller;

import cn.hust.dto.OrderDTO;
import cn.hust.enums.ResultEnum;
import cn.hust.exception.SellException;
import cn.hust.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 卖家端
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-11 20:44
 **/
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     *
     * @param page 第几页，从1页开始
     * @param size 一页有多少数据
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        //map直接将orderDTOPage对象注入进去，所以页面在取值时直接orderDTOPage.orderId,而不是orderDTOPage.getOrderId
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("/order/list",map);
    }

    /**
     * 取消订单
     * @param orderId
     * @param map
     * @return
     */

    @RequestMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            e.printStackTrace();
            log.error("【卖家端取消订单】，发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS);
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家端取消订单】，发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("orderDTO",orderDTO);
        return new ModelAndView("/order/detail",map);

    }

    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId
                               ){

        //注意这里Map<String,Object> map的选择问题，如果finished函数入参中没有Map<String,Object> map，则最后return时必须带走map,否则界面显示不出来
        //但如果入参中有，程序中对这个Map进行了操作，会自动带入下一个界面
        Map<String,Object> map = new HashMap<>();
        try {
            OrderDTO orderDTO  = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】，发生异常{}",e);

            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS);
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);

    }



}
