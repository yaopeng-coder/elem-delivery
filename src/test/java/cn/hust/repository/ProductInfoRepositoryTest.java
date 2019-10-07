package cn.hust.repository;

import cn.hust.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void savaTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("222");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("好吃");
        productInfo.setProductIcon("http://xxx.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> results = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,results.size());
    }

}