package cn.hust.repository;

import cn.hust.dataobject.SellerInfo;
import cn.hust.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {


    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("adss");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOpenid() throws Exception {

        SellerInfo result = repository.findByOpenid("adss");
        Assert.assertEquals("adss",result.getOpenid());

    }

}