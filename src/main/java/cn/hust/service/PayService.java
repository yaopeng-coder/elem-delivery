package cn.hust.service;

import cn.hust.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * 支付
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 15:16
 **/
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

}
