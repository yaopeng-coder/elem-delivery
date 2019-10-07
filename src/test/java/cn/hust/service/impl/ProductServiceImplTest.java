package cn.hust.service.impl;

import cn.hust.dataobject.ProductInfo;
import cn.hust.enums.ProductStatusEnum;
import cn.hust.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = productService.findOne("222");
        Assert.assertEquals("222",result.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> result = productService.findAll(pageRequest);
        System.out.println(result.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("321");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(10.2));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("很皮");
        productInfo.setProductIcon("http://xxx.com");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}