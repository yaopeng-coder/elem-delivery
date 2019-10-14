package cn.hust.service.impl;

import cn.hust.dto.OrderDTO;
import cn.hust.service.OrderService;
import cn.hust.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    PushMessageService pushMessageService;

    @Autowired
    OrderService orderService;

    @Test
    public void orderStatus() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1570540061932719482");
        pushMessageService.orderStatus(orderDTO);
    }

}