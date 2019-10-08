package cn.hust.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-08 17:45
 **/
@Data
public class OrderForm {

    /** 买家姓名. */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家电话. */
    @NotEmpty(message = "电话必填")
    private String phone;

    /** 买家地址. */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家微信号. */
    @NotEmpty(message = "微信号必填")
    private String openid;

    /** 购物车. */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
