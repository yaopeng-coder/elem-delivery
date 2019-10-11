package cn.hust.service.impl;

import cn.hust.dto.OrderDTO;
import cn.hust.enums.ResultEnum;
import cn.hust.exception.SellException;
import cn.hust.service.OrderService;
import cn.hust.service.PayService;
import cn.hust.utils.JsonUtil;
import cn.hust.utils.MathUtil;
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

    @Autowired
    private  OrderService orderService;

    //发起支付
    @Override
    public PayResponse create(OrderDTO orderDTO) {


        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        //doubleValue()将BIGdecimal类型转换为double
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付， request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse= bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付， response={}",JsonUtil.toJson(payResponse));
        return payResponse;

    }

    @Override
    public PayResponse notify(String notifyData) {
        //1.验证签名
        //2.支付的状态
        //3.支付金额
        //4.支付人（下单人==支付人）
        //前两点bestpay sdk已经帮我们做了


        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】 异步通知，payResponse={}",JsonUtil.toJson(payResponse));

        //查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        //判断订单是否存在
        if(orderDTO == null){
            log.error("【微信支付】异步通知，orderId={}",orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //判断金额是否一致
        if(!MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("【微信支付】异步通知，orderId={}，微信通知金额={}，系统金额={}",
                    orderDTO.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        //修改订单订单状态
        orderService.paid(orderDTO);

        return payResponse;
    }
}
