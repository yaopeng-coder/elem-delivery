package cn.hust.repository;

import cn.hust.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 21:22
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
