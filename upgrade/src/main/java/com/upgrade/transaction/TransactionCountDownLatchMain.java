package com.upgrade.transaction;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangjiaw
 * @Date 2021/9/21 12:27
 */
public class TransactionCountDownLatchMain {
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        for (int i=0; i<5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    countDownLatch.await();
                    String name = Thread.currentThread().getName();
                    String[] split = name.split("-");
                    restTemplate.getForObject(
                            "http://localhost:13000/transaction/optimisticLock?dataId=1", String.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            countDownLatch.countDown();
        }
    }
}
