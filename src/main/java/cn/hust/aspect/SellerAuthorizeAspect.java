package cn.hust.aspect;

import cn.hust.constant.CookieConstant;
import cn.hust.constant.RedisConstant;
import cn.hust.exception.SellerAuthorizeException;
import cn.hust.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: elem-delivery
 * @author: yaopeng
 * @create: 2019-10-14 16:08
 **/
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * cn.hust.controller.Seller*.*(..))"+
            "&&!execution(public * cn.hust.controller.SellerUserController.*(..))")
    public void verify(){}


    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie == null){
            log.warn("【登录校验】cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】redis中查不到token");
            throw new SellerAuthorizeException();
        }

    }
}
