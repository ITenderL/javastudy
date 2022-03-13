package com.itender;

import com.alibaba.fastjson.JSON;
import com.itender.pojo.Good;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @Author: ITender
 * @Date: 2022/03/13/ 21:59
 * @Description:
 */
@SpringBootTest
public class TestRestHighLevelClientForDocument {
    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public TestRestHighLevelClientForDocument(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * 创建文档
     *
     * @throws IOException
     */
    @Test
    public void testCreate() throws IOException {
        IndexRequest indexRequest = new IndexRequest("goods");
        Good good = new Good();
        good.setTitle("日本豆");
        good.setPrice(3.5);
        good.setDescription("日本豆很好吃！");
        good.setCreateTime("2022-03-13");
        indexRequest.id("2").source(JSON.toJSONString(good), XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 更新文档
     *
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("goods", "1");
        updateRequest.doc("{\"price\":1.9}", XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 删除文档
     */
    @Test
    public void testDelete() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("goods", "1");
        DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 根据id查询文档
     */
    @Test
    public void testQueryById() throws IOException {
        GetResponse response = restHighLevelClient.get(new GetRequest("goods", "1"), RequestOptions.DEFAULT);
        System.out.println(response.getSource());
    }
}
