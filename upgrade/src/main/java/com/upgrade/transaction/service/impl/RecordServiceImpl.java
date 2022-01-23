package com.upgrade.transaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upgrade.transaction.entity.Data;
import com.upgrade.transaction.entity.Record;
import com.upgrade.transaction.enums.DataStatusEnum;
import com.upgrade.transaction.enums.RecordStatusEnum;
import com.upgrade.transaction.mapper.DataMapper;
import com.upgrade.transaction.mapper.RecordMapper;
import com.upgrade.transaction.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:10
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateByOptimisticLock(Data data, Record record)
            throws Exception{
        UpdateWrapper<Data> updateWrapper = Wrappers.update();
        updateWrapper.ne("status", DataStatusEnum.OPERATED.getValue());
        int update = dataMapper.update(data, updateWrapper);
        if (update == 0) {
            throw new RuntimeException("重复操作！");
        }
        data.setStatus(DataStatusEnum.OPERATED.getValue());
        dataMapper.updateById(data);
        record.setStatus(RecordStatusEnum.SUCCESS.getValue());
        this.updateById(record);
    }
}
