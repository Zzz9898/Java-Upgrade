package com.upgrade.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upgrade.transaction.entity.Data;
import com.upgrade.transaction.mapper.DataMapper;
import com.upgrade.transaction.service.DataService;
import org.springframework.stereotype.Service;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:07
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, Data> implements DataService {
}
