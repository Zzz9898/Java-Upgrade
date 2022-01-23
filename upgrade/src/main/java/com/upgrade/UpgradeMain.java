package com.upgrade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhangjiaw
 * @Date 2021/11/13 23:12
 */
@SpringBootApplication
@MapperScan("com.upgrade.**.mapper")
public class UpgradeMain {
    public static void main(String[] args) {
        SpringApplication.run(UpgradeMain.class);
    }
}
