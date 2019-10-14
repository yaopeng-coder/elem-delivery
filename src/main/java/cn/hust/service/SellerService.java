package cn.hust.service;

import cn.hust.dataobject.SellerInfo;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 10:59
 **/
public interface SellerService {

    SellerInfo findSellInfoByOpenid(String openid);
}
