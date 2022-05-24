package com.upgrade.currentlimit;

import com.upgrade.exception.ServiceException;
import com.upgrade.util.IpAddressUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author zhangjiaw
 * @Date 2022/5/24 21:19
 */
@Aspect
@Component
public class RateLimiterAspect {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterAspect.class);

    private final static Map<LimitType, String> limitTypeMap = new HashMap<>();

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private LuaScriptContainer luaScriptContainer;

    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter){
        String key = rateLimiter.key();
        int time = rateLimiter.time();
        int count = rateLimiter.count();

        String combineKey = getCombineKey(rateLimiter, point);
        List<Object> keys = Collections.singletonList(combineKey);
        try{
            Long number = redisTemplate.execute(luaScriptContainer.limitScript(), keys, count, time);
            if (number == null || number.intValue() > count) {
                throw new ServiceException("访问过于频繁，请稍候再试");
            }
            log.info("限制请求'{}',当前请求'{}',缓存key'{}'", count, number.intValue(), key);
        } catch (ServiceException e) {
            throw e;
        }catch (Exception e) {
            throw new RuntimeException("服务器限流异常，请稍候再试");
        }
    }

    private String getCombineKey(RateLimiter rateLimiter, JoinPoint point) {
        limitTypeMap.put(LimitType.IP, "-" + IpAddressUtil.getIpAddress(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()) + "-");
        StringBuilder stringBuffer = new StringBuilder(rateLimiter.key());
        stringBuffer.append(limitTypeMap.getOrDefault(rateLimiter.limitType(), ""));
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        stringBuffer.append(targetClass.getName()).append("-").append(method.getName());
        return stringBuffer.toString();
    }
}
