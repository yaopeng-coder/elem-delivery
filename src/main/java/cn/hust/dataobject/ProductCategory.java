package cn.hust.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 09:10
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名. */
    private String categoryName;

    /** 类目类型. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;


    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
