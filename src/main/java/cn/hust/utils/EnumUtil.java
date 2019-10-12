package cn.hust.utils;


import cn.hust.enums.CodeEnum;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-11 21:43
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants() ){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
