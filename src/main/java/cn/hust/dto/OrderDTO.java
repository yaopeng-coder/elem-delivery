package cn.hust.dto;

import cn.hust.dataobject.OrderDetail;
import cn.hust.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-08 09:45
 **/
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 卖家地址. */
    private String buyerAddress;

    /** 买家微信号. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态,默认新下单. */
    private Integer orderStatus ;

    /** 支付状态,默认未支付. */
    private Integer payStatus ;

    /** 订单创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 订单更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

   List<OrderDetail> orderDetailList;
   // List<CartDTO> cartDTOList;
}
