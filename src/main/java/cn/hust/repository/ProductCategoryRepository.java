package cn.hust.repository;

import cn.hust.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 09:10
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
