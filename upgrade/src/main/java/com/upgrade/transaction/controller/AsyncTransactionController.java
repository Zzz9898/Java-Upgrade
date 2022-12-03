package com.upgrade.transaction.controller;

import com.upgrade.transaction.service.AsyncTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangjiaw
 * @Date 2022/6/20 23:19
 */
@RestController
public class AsyncTransactionController {

    @Autowired
    private AsyncTransactionService asyncTransactionService;

    @GetMapping("/asyncTransactionTest")
    public String asyncTransactionTest(){
        return asyncTransactionService.asyncMain();
    }
}
