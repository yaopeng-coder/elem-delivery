package cn.hust.repository;

import cn.hust.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 10:45
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}
