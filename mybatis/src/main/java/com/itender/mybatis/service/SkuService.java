package com.itender.mybatis.service;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.itender.mybatis.dao.SkuMapper;
import com.itender.mybatis.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-24 16:41
 * @Description:
 */
@Service
public class SkuService {
    private final SkuMapper skuMapper;

    @Autowired
    public SkuService(SkuMapper skuMapper) {
        this.skuMapper = skuMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void batchInsert(Long id) {
        List<Sku> skuList = skuMapper.getSkuList(id);
        System.out.println("foreach start:" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        // skuMapper.batchInsert(skuList);
        Lists.partition(skuList, 100).forEach(skuMapper::batchInsert);
        System.out.println("foreach end:" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

    }
}
