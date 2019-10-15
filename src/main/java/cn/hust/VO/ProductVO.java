package cn.hust.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品(包含类目)
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 16:36
 **/
@Data
public class ProductVO implements Serializable{


    private static final long serialVersionUID = 9106287868504259182L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
