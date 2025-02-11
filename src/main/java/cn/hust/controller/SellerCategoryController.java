package cn.hust.controller;

import cn.hust.dataobject.ProductCategory;
import cn.hust.exception.SellException;
import cn.hust.form.CategoryForm;
import cn.hust.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-13 16:32
 **/
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("/category/list",map);

    }

    /**
     * 类目修改转的界面
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
        if(categoryId != null){
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category",category);
        }

        return new ModelAndView("category/index",map);

    }

    /**
     * 类目修改后保存
     * @param categoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                             Map<String,Object> map){

        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        ProductCategory productCategory  = new ProductCategory();

        try {
            if(categoryForm.getCategoryId() != null){
                productCategory = categoryService.findOne(categoryForm.getCategoryId());
            }
            Integer id  = productCategory.getCategoryId();
            BeanUtils.copyProperties(categoryForm,productCategory);
            productCategory.setCategoryId(id);
        } catch (SellException e) {
           map.put("msg",e.getMessage());
           map.put("url","/sell/seller/category/index");
           return new ModelAndView("common/error",map);
        }

        categoryService.save(productCategory);
        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);

    }
}
