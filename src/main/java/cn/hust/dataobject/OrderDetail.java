package cn.hust.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 21:06
 **/
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 产品id. */
    private String productId;

    /** 产品名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 产品数量. */
    private Integer poductQuantity;

    /** 产品图片. */
    private String productIcon;
}
