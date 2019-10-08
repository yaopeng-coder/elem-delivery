package cn.hust.service.impl;

import cn.hust.dataobject.OrderDetail;
import cn.hust.dto.OrderDTO;
import cn.hust.enums.OrderStatusEnum;
import cn.hust.enums.PayStatusEnum;
import cn.hust.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String PRODUCT_ID = "222";
    private final String OPEN_ID = "eesfsg";
    private final String ORDER_ID = "1570514506206959940";

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
        orderDetail.setProductId("PRODUCT_ID");
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
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("查询订单，result ={} ",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> result = orderService.findList(OPEN_ID, pageRequest);
        Assert.assertNotEquals(0,result);

    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

}