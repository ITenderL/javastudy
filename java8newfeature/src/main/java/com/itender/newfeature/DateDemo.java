package com.itender.newfeature;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author itender
 * @date 2022/6/10 16:09
 * @desc
 */
public class DateDemo {
    public static void main(String[] args) {
        // String dateStr = "2017-03-01 22:33:23";
        // Date date = DateUtil.parse(dateStr);
        // //结果：2017-03-03 22:33:23
        // Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        // System.out.println(newDate);
        //常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(new Date(), -6);
        System.out.println(newDate2);
        //常用偏移，结果：2017-03-01 19:33:23
        // DateTime newDate3 = DateUtil.offsetHour(date, -3);
        // System.out.println(newDate3);

        String str = "{\n" +
                " \"filters\": [\n" +
                "  {\n" +
                "   \"key\": \"Theater\",\n" +
                "   \"value\": \"地区\",\n" +
                "   \"canSeparateAnalyze\": true,\n" +
                "   \"indexKey\": \"theater\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Channel\",\n" +
                "   \"value\": \"渠道\",\n" +
                "   \"indexKey\": \"feedbackChannel\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Model\",\n" +
                "   \"value\": \"机型\",\n" +
                "   \"canSeparateAnalyze\": true,\n" +
                "   \"indexKey\": {\n" +
                "        \"voc_original_warn_detail\":\"newCustModel\",\n" +
                "     \"voc_original_warn_label\":\"newCustModel\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"VocLabel\",\n" +
                "   \"value\": \"VOC标签\",\n" +
                "   \"canSeparateAnalyze\": true,\n" +
                "   \"indexKey\": {\n" +
                "        \"voc_original_warn_detail\":\"vocMalfunction.vocMalfunctionId\",\n" +
                "     \"voc_original_warn_label\":\"malfunctionId\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Emotion\",\n" +
                "   \"value\": \"情感\",\n" +
                "   \"indexKey\": {\n" +
                "        \"voc_original_warn_detail\":\"vocMalfunction.emotionAttribute\",\n" +
                "     \"voc_original_warn_label\":\"emotionAttribute\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Keyword\",\n" +
                "   \"value\": \"关键词\",\n" +
                "   \"isSeparateWords\": true,\n" +
                "   \"indexKey\": {\n" +
                "        \"voc_original_warn_detail\":\"userContent\",\n" +
                "     \"voc_original_warn_label\":\"userContent\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Brand\",\n" +
                "   \"value\": \"品牌\",\n" +
                "   \"indexKey\": {\n" +
                "        \"voc_original_warn_detail\":\"brand\",\n" +
                "     \"voc_original_warn_label\":\"brand\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"GameName\",\n" +
                "   \"value\": \"游戏名称\",\n" +
                "   \"indexKey\": {\n" +
                "     \"voc_original_warn_label\":\"gamename\"\n" +
                "   },\n" +
                "   \"isDynamicUpdate\": true,\n" +
                "   \"canSeparateAnalyze\": true,\n" +
                "   \"preconditionMonitorFilters\": [\n" +
                "    \"VocLabel\"\n" +
                "   ]\n" +
                "  }\n" +
                " ],\n" +
                " \"measures\": [\n" +
                "  {\n" +
                "   \"key\": \"FeedbackQuantity\",\n" +
                "   \"value\": \"反馈量\",\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Value\",\n" +
                "    \"Difference\",\n" +
                "    \"ChainedValueOfDifference\",\n" +
                "    \"DifferenceFromAverage\",\n" +
                "    \"ChainedValueOfDifferenceToAverage\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"CurrentDay\",\n" +
                "    \"Recent7days\",\n" +
                "    \"Recent30days\"\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"LabelFeedbackQuantityProportion\",\n" +
                "   \"value\": \"标签反馈量占比\",\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"CurrentDay\",\n" +
                "    \"Recent7days\",\n" +
                "    \"Recent30days\"\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"NPS\",\n" +
                "   \"value\": \"NPS值\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Value\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ],\n" +
                "   \"displayPercentSign\": true\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"FavorableRateOfGoods\",\n" +
                "   \"value\": \"当期商品好评率\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"CurrentDay\",\n" +
                "    \"Recent7days\",\n" +
                "    \"Recent30days\"\n" +
                "   ],\n" +
                "   \"displayPercentSign\": true\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"AccFavorableRateOfGoods\",\n" +
                "   \"value\": \"累计商品好评率\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ],\n" +
                "   \"displayPercentSign\": true\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"NumberOfFans\",\n" +
                "   \"value\": \"粉丝量\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"NumberOfComment\",\n" +
                "   \"value\": \"评论量\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"NumberOfForwarding\",\n" +
                "   \"value\": \"转发量\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Likes\",\n" +
                "   \"value\": \"点赞量\",\n" +
                "   \"preconditionFilter\": [\n" +
                "    {\n" +
                "     \"filter\": \"Channel\",\n" +
                "     \"condition\": \"equals\",\n" +
                "     \"value\": \"NPS\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"allowsCaculateMethods\": [\n" +
                "    \"Difference\"\n" +
                "   ],\n" +
                "   \"allowPeriods\": [\n" +
                "    \"UpToNow\"\n" +
                "   ]\n" +
                "  }\n" +
                " ],\n" +
                " \"periods\": [\n" +
                "  {\n" +
                "   \"key\": \"CurrentDay\",\n" +
                "   \"value\": \"当日\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Recent7days\",\n" +
                "   \"value\": \"近7天\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Recent30days\",\n" +
                "   \"value\": \"近30天\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"UpToNow\",\n" +
                "   \"value\": \"累计至今\"\n" +
                "  }\n" +
                " ],\n" +
                " \"caculateMethods\": [\n" +
                "  {\n" +
                "   \"key\": \"Value\",\n" +
                "   \"value\": \"值\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Difference\",\n" +
                "   \"value\": \"差值\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"ChainedValueOfDifference\",\n" +
                "   \"value\": \"环比率\",\n" +
                "   \"displayPercentSign\": true\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"DifferenceFromAverage\",\n" +
                "   \"value\": \"与平均值的差值\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"ChainedValueOfDifferenceToAverage\",\n" +
                "   \"value\": \"较平均值的环比率\",\n" +
                "   \"displayPercentSign\": true\n" +
                "  }\n" +
                " ],\n" +
                " \"operators\": [\n" +
                "  {\n" +
                "   \"key\": \"Gt\",\n" +
                "   \"value\": \">\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Gte\",\n" +
                "   \"value\": \">=\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Lt\",\n" +
                "   \"value\": \"<\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"key\": \"Lte\",\n" +
                "   \"value\": \"<=\"\n" +
                "  }\n" +
                " ],\n" +
                " \"warningLevels\": [\n" +
                "  \"A\",\n" +
                "  \"B\",\n" +
                "  \"C\",\n" +
                "  \"D\"\n" +
                " ]\n" +
                "}";
        StringEscapeUtils.unescapeJava(str);
        Map map = JSON.parseObject(str, Map.class);
        System.out.println(map);
    }
}
