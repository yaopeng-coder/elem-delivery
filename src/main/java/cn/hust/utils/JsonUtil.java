package cn.hust.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-10 21:06
 **/
public class JsonUtil {

    public static  String  toJson(Object object){
        GsonBuilder gsonBuilder  =  new GsonBuilder();
        //对结果进行格式化，增加换行
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
