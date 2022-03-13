package com.itender.mybatis.controller;

import com.itender.mybatis.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-24 16:39
 * @Description:
 */
@RestController
@RequestMapping(value = "sku")
public class SkuController {

    private final SkuService skuService;

    @Autowired
    public SkuController(SkuService skuService) {
        this.skuService = skuService;
    }

    @GetMapping("test/{id}")
    public void batchInsert(@PathVariable("id") Long id) {
        skuService.batchInsert(id);
    }
}
