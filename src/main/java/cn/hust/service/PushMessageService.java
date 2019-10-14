package cn.hust.service;

import cn.hust.dto.OrderDTO;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 17:02
 **/
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);

}
