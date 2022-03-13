package com.itender;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @Author: ITender
 * @Date: 2022/03/13/ 21:31
 * @Description:
 */
@SpringBootTest
public class TestRestHighLevelClientForIndex {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     */
    @Test
    public void testIndexAndMapping() throws IOException {
        // 参数：1.映射结构 json结构 2.指定数据类型
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("goods").mapping(
                "{\n" +
                        "    \"properties\": {\n" +
                        "      \"title\":{\n" +
                        "        \"type\": \"keyword\"\n" +
                        "      },\n" +
                        "      \"price\":{\n" +
                        "        \"type\": \"double\"\n" +
                        "      },\n" +
                        "      \"createTime\":{\n" +
                        "        \"type\": \"date\"\n" +
                        "      },\n" +
                        "      \"description\":{\n" +
                        "        \"type\": \"text\",\n" +
                        "        \"analyzer\": \"ik_max_word\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }", XContentType.JSON);
        // 参数：1.创建索引请求对象 2.请求配置对象
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
        // 关闭连接
        restHighLevelClient.close();
    }

    /**
     * 删除索引
     */
    @Test
    public void testDeleteIndex() throws IOException {
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(new DeleteIndexRequest("goods"), RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
    }
}
