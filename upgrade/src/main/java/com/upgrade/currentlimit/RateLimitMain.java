package com.upgrade.currentlimit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author zhangjiaw
 * @Date 2022/5/24 21:52
 */
@RestController
public class RateLimitMain {

    @GetMapping("/reteLimit/ip")
    @RateLimiter(time = 10, count = 2, limitType = LimitType.IP)
    public String rateLimitIp() {
        return "hello>>>" + new Date();
    }

    @GetMapping("/reteLimit/time")
    @RateLimiter(time = 10, count = 5)
    public String rateLimitTime() {
        return "hello>>>" + new Date();
    }
}