package cn.hust.utils;

import java.util.Random;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-08 10:26
 **/
public class KeyUtil {

    /**
     * 生成唯一主键
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
