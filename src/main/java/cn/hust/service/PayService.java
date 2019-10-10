package cn.hust.service;

import cn.hust.dto.OrderDTO;

/**
 * 支付
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 15:16
 **/
public interface PayService {

    void create(OrderDTO orderDTO);
}
