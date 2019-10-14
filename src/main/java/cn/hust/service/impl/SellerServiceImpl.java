package cn.hust.service.impl;

import cn.hust.dataobject.SellerInfo;
import cn.hust.repository.SellerInfoRepository;
import cn.hust.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 11:00
 **/
@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    private  SellerInfoRepository repository;

    @Override
    public SellerInfo findSellInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
