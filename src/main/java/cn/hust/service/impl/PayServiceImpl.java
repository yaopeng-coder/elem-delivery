package cn.hust.service.impl;

import cn.hust.dto.OrderDTO;
import cn.hust.service.PayService;
import cn.hust.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 15:22
 **/
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private  static final String ORDER_NAME  = "微信点餐系统";

    @Autowired
    private BestPayServiceImpl bestPayService;

    //发起支付
    @Override
    public void create(OrderDTO orderDTO) {


        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        //doubleValue()将BIGdecimal类型转换为double
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付 request={}】", JsonUtil.toJson(payRequest));
        PayResponse payResponse= bestPayService.pay(payRequest);
        log.info("【微信支付response={}】，",JsonUtil.toJson(payResponse));

    }
}
