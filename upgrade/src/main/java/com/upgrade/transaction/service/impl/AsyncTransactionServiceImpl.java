package com.upgrade.transaction.service.impl;

import com.upgrade.transaction.mapper.DataMapper;
import com.upgrade.transaction.service.AsyncTransactionService;
import com.upgrade.transaction.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangjiaw
 * @Date 2022/6/20 23:16
 */
@Service
public class AsyncTransactionServiceImpl implements AsyncTransactionService {

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private BusinessService businessService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String asyncMain(){
        System.out.println("asyncMain----------------begin");
        System.out.println(Thread.currentThread().getName());
        businessService.asyncMore();
        System.out.println("asyncMain----------------down");
        return "success";
    }

    @Async
    @Override
    public void asyncMore(){
        try {
            System.out.println("asyncMore----------------begin");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("asyncMore----------------down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
