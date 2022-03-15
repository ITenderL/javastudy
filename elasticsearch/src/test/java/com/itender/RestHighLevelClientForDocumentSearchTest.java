package com.itender;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: ITender
 * @Date: 2022/03/14/ 22:12
 * @Description:
 */
@SpringBootTest
public class RestHighLevelClientForDocumentSearchTest {

    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public RestHighLevelClientForDocumentSearchTest(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 查询所有
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("总条数："+searchResponse.getHits().getTotalHits().value);
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            System.out.println(hit.getSourceAsString());
        }
    }


    /**
     * 条件查询
     */
    @Test
    public void testQuery() throws IOException {
        // 1.term查询  匹配查询
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("description", "浣熊");
        // 2.range查询 范围查询
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").gte(1.0).lte(6.0);
        // 3. prefix前缀查询
        PrefixQueryBuilder prefixQueryBuilder = QueryBuilders.prefixQuery("description", "日本");
        // 4.通配符查询 ？代表一个字符  *代表多个字符
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("title", "小*");
        // 5.ids id集合查询
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        // System.out.println(StringUtils.join(list.toArray(), ","));
        IdsQueryBuilder idsQueryBuilder = QueryBuilders.idsQuery().addIds("1", "2");
        search(idsQueryBuilder);
    }

    private void search(QueryBuilder queryBuilder) throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("总条数："+response.getHits().getTotalHits());
        Arrays.stream(response.getHits().getHits()).forEach(hit -> System.out.println(hit.getSourceAsString()));
    }

    /**
     * 分页查询 from: 起始位置  size: 每页展示记录
     * 排序 sort
     */
    @Test
    public void testSearchByPage() throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder().requireFieldMatch(false).field("description").preTags("<span style='color:red;'>").postTags("</span>");
        // sourceBuilder.query(QueryBuilders.matchAllQuery())
        sourceBuilder.query(QueryBuilders.termQuery("description", "好吃"))
                .from(0) // 起始位置
                .size(10) // 每页的记录数
                .sort("price", SortOrder.DESC) // 排序
                .fetchSource(new String[]{}, new String[]{"createTime"}) // 参数 1.包含的字段数组 2.排除的字段数组
                .highlighter(highlightBuilder);// 高亮
        searchRequest.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("总条数："+response.getHits().getTotalHits().value);
        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println(hit.getSourceAsString());
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (highlightFields.containsKey("description")) {
                System.out.println(highlightFields.get("description").fragments()[0]);
            }
        }

    }
}
