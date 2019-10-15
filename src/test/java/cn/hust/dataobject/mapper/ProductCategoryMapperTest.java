package cn.hust.dataobject.mapper;

import cn.hust.ElemDeliveryApplication;
import cn.hust.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 注意这里的单元测试必须引入webenvironment，因为你引入了websocket,不加会报错
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElemDeliveryApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    ProductCategoryMapper categoryMapper;


    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(103);
        int result = categoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectTest(){
        ProductCategory pro = categoryMapper.findByCategoryType(1);
        log.info("{}",pro);
        Assert.assertNotNull(pro);
    }

    @Test
    public void selectTest1(){
        List<ProductCategory> pro = categoryMapper.findByCategoryName("师兄最不爱");
        log.info("{}",pro);
        Assert.assertNotEquals(0,pro.size());
    }

    @Test
    public void updateTest(){
        int result = categoryMapper.updateByCategoryType("猪猪最爱",102);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateObjectTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("猪猪最不爱");
        productCategory.setCategoryType(103);
        int result = categoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }
}