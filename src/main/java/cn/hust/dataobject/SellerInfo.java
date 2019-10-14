package cn.hust.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 10:42
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String  username;

    private String  password;

    private String openid;
}
