package com.upgrade.transaction.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangjiaw
 * @Date 2022/6/20 23:15
 */
public interface AsyncTransactionService {
    String asyncMain();

    void asyncMore();
}
