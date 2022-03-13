package com.itender;

import com.itender.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITender
 * @Date: 2022/03/13/ 19:36
 * @Description:
 */
@SpringBootTest
public class ElasticsearchTest {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    /**
     * 添加   修改  文档
     * elasticsearchOperations.save()
     * 索引一条文档，也可以更新一条文档
     */
    @Test
    public void indexTest() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("小浣熊");
        product.setPrice(1.5);
        product.setDescription("小浣熊干脆面真好吃，曾经最爱吃！");
        Product product1 = new Product();
        product1.setId(2);
        product1.setTitle("日本豆");
        product1.setPrice(3.5);
        product1.setDescription("日本豆干脆面真好吃，曾经最爱吃！");
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(product1);
        elasticsearchOperations.save(list);
    }

    /**
     * 查询文档
     */
    @Test
    public void testSearch() {
        Product product = elasticsearchOperations.get("1", Product.class);
        System.out.println(product);
    }

    /**
     * 删除文档
     */
    @Test
    public void testDelete() {
        Product product = new Product();
        product.setId(1);
        elasticsearchOperations.delete(product);
    }

    /**
     * 删除所有
     */
    @Test
    public void testDeleteAll() {
        elasticsearchOperations.delete(Query.findAll(), Product.class);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        SearchHits<Product> productSearchHits = elasticsearchOperations.search(Query.findAll(), Product.class);
        productSearchHits.forEach(System.out::print);
    }

}
