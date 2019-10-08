package cn.hust.repository;

import cn.hust.dataobject.OrderDetail;
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
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1222");
        orderDetail.setOrderId("1234222");
        orderDetail.setProductId("222");
        orderDetail.setProductName("大闸蟹");
        orderDetail.setProductPrice(new BigDecimal(22));
        orderDetail.setProductQuantity(11);
        orderDetail.setProductIcon("http:www.jpg");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1234");
        Assert.assertNotEquals(0,orderDetailList.size());


    }

}