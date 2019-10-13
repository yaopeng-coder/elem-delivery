package cn.hust.dataobject;

import cn.hust.enums.ProductStatusEnum;
import cn.hust.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 14:42
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
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

   /** 商品状态,0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号. */
    private Integer categoryType;

    /** 产品上架时间. */
    private Date createTime;

    /** 产品更新时间. */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
