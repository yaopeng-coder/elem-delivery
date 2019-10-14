package cn.hust.service.impl;

import cn.hust.dataobject.SellerInfo;
import cn.hust.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid = "adss";

    @Autowired
    private SellerService sellerService;


    @Test
    public void findSellInfoByOpenid() throws Exception {
        SellerInfo resutl = sellerService.findSellInfoByOpenid(openid);
        Assert.assertEquals(openid,resutl.getOpenid());
    }

}