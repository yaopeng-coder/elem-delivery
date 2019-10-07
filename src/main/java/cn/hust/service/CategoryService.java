package cn.hust.service;

import cn.hust.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 09:10
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();


    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);



}
