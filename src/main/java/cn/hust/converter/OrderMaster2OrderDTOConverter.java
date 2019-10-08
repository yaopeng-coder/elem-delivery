package cn.hust.converter;

import cn.hust.dataobject.OrderMaster;
import cn.hust.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-08 14:52
 **/
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return orderDTOList;
    }
}
