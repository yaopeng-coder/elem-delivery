package cn.hust.repository;

import cn.hust.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 14:55
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
