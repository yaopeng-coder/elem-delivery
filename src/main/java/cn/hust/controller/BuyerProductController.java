package cn.hust.controller;

import cn.hust.VO.ProductInfoVO;
import cn.hust.VO.ProductVO;
import cn.hust.VO.ResultVO;
import cn.hust.dataobject.ProductCategory;
import cn.hust.dataobject.ProductInfo;
import cn.hust.service.CategoryService;
import cn.hust.service.ProductService;
import cn.hust.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 16:14
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/list")
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        System.out.println(productInfoList);

        //2.查询类目(一次性查询)
        //传统方法
        List<Integer> categoryTypeList = new ArrayList<>();
        for(ProductInfo productInfo: productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //精简方法(java8,lambda)
//        List<Integer> categoryTypeList = productInfoList.stream()
//                .map(e -> e.getCategoryType())
//                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList  = categoryService.findByCategoryTypeIn(categoryTypeList);
        System.out.println(productCategoryList);


        //3. 数据封装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType() == productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }


}
