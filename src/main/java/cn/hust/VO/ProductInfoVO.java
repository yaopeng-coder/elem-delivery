package cn.hust.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 16:31
 **/
@Data
public class ProductInfoVO implements Serializable{

    private static final long serialVersionUID = -6211954966688661318L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
