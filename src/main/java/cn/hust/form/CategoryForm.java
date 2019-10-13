package cn.hust.form;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-13 17:00
 **/
@Data
@DynamicUpdate
public class CategoryForm {

    private Integer categoryId;

    /** 类目名. */
    private String categoryName;

    /** 类目类型. */
    private Integer categoryType;


}
