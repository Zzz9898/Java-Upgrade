package com.upgrade.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.upgrade.transaction.entity.Data;
import com.upgrade.transaction.entity.Record;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:06
 */
public interface RecordService extends IService<Record> {
    void updateByOptimisticLock(Data data, Record record) throws Exception;
}
