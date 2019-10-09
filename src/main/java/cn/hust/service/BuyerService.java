package cn.hust.service;

import cn.hust.dto.OrderDTO;

/**
 * 买家
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-09 14:09
 **/
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
