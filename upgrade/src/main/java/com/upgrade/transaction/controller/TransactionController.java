package com.upgrade.transaction.controller;

import com.upgrade.common.JsonResult;
import com.upgrade.transaction.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:13
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/optimisticLock")
    public JsonResult<String> optimisticLock(@RequestParam Integer dataId){
        try {
            businessService.optimisticLock(dataId);
            return JsonResult.success();
        }catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail();
        }
    }
}
