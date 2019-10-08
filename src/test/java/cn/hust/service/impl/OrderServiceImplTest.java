package cn.hust.service.impl;

import cn.hust.dataobject.OrderDetail;
import cn.hust.dto.OrderDTO;
import cn.hust.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小雅");
        orderDTO.setBuyerPhone("18868822111");
        orderDTO.setBuyerAddress("华科");
        orderDTO.setBuyerOpenid("eesfsg");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("222");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        /*List<CartDTO> orderDetailList = new ArrayList<>();
        CartDTO orderDetail = new CartDTO();
        orderDetail.setProductId("321");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);*/

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单："+result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findList() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}