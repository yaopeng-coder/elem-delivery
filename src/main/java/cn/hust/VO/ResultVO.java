package cn.hust.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回给前端的最外层
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-07 16:10
 **/
@Data
public class ResultVO<T> implements Serializable {


 private static final long serialVersionUID = -5799650565138163518L;

 /** 错误码. */
     private Integer code;

     /** 提示信息. */
     private String msg;

     /** 具体内容. */
     private T data;

}
