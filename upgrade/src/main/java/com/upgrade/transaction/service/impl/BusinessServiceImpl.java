package com.upgrade.transaction.service.impl;

import com.upgrade.transaction.entity.Data;
import com.upgrade.transaction.entity.Record;
import com.upgrade.transaction.enums.RecordStatusEnum;
import com.upgrade.transaction.service.BusinessService;
import com.upgrade.transaction.service.DataService;
import com.upgrade.transaction.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:15
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private DataService dataService;

    @Autowired
    private RecordService recordService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void optimisticLock (Integer dataId)
            throws Exception{
        Data data = dataService.getBaseMapper().selectById(dataId);
        Record record = buildRecord(data);
        recordService.getBaseMapper().insert(record);
        recordService.updateByOptimisticLock(data, record);
    }

    private Record buildRecord(Data data) {
        Record record = new Record();
        record.setDataId(data.getId());
        record.setDataStatus(data.getStatus());
        record.setStatus(RecordStatusEnum.WAIT.getValue());
        return record;
    }
}
