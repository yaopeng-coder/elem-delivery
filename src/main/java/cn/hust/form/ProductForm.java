package cn.hust.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-13 15:17
 **/
@Data
public class ProductForm {

    private String productId;

    /** 商品名称. */
    private String productName;

    /**  单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;


    /** 类目编号. */
    private Integer categoryType;
}
