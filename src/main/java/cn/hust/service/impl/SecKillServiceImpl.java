package cn.hust.service.impl;


import cn.hust.exception.SellException;
import cn.hust.service.RedisLock;
import cn.hust.service.SecKillService;
import cn.hust.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 秒杀
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-15 11:00
 **/
@Service
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10 * 1000; //超时时间 10s

    @Autowired
    private RedisLock redisLock;

    /**
     * 国庆活动，皮蛋粥特价，限量100000份
     */
    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;
    static
    {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String queryMap(String productId)
    {
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                +" 还剩：" + stock.get(productId)+" 份"
                +" 该商品成功下单用户数目："
                +  orders.size() +" 人" ;
    }

    @Override
    public String querySecKillProductInfo(String productId)
    {
        return this.queryMap(productId);
    }


    /**
     * 使用synchronized无法做到细粒度控制，例如现在秒杀这个方法里有很多商品，A商品秒杀的人很多，B很少，但是他们都会一样的慢，
     * 并且他们只适合单点登录，万一搞个负载均衡，大家看到的情况都不一样
     * @param productId
     */
    @Override
    public synchronized void orderProductMockDiffUser(String productId)
    {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101,"哎哟喂，人太多啦，换个姿势再试试");
        }

        //1.查询该商品库存，为0则活动结束。
        int stockNum = stock.get(productId);
        if(stockNum == 0) {
            throw new SellException(100,"活动结束");
        }else {
            //2.下单(模拟不同用户openid不同)
            orders.put(KeyUtil.getUniqueKey(),productId);
            //3.减库存
            stockNum =stockNum-1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        //解锁

        redisLock.unlock(productId,String.valueOf(time));

    }
}
