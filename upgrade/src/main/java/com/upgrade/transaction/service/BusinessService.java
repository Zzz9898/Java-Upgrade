package com.upgrade.transaction.service;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:14
 */
public interface BusinessService {
    void optimisticLock(Integer dataId) throws Exception;

    void asyncMore();
}
