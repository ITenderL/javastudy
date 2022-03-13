package com.itender.mybatis.dao;

import com.itender.mybatis.entity.Sku;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-24 16:41
 * @Description:
 */
public interface SkuMapper extends Mapper<Sku> {

    /**
     * 批量插入sku
     *
     * @param skuList
     */
    void batchInsert(@Param("skuList") List<Sku> skuList);

    /**
     * 查询skuList
     *
     * @param id
     * @return
     */
    List<Sku> getSkuList(Long id);
}
