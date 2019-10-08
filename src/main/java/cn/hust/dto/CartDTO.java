package cn.hust.dto;

import lombok.Data;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-08 11:29
 **/
@Data
public class CartDTO {

    /** 商品id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
