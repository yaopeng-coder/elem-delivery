package cn.hust.dataobject;

import cn.hust.enums.OrderStatusEnum;
import cn.hust.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 20:54
 **/
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    /** 卖家名字. */
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 订单创建时间. */
    private Date createTime;

    /** 订单更新时间. */
    private Date updateTime;
}
