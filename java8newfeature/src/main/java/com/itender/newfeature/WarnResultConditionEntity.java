package com.itender.newfeature;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WarnResultConditionEntity implements Serializable {
    private List<String> modelList;
    private List<String> brandList;
    private List<String> vocLabelList;
    private Integer vocLabelLevel;
    private List<String> faultPhenomenonList;
    private Integer faultPhenomenonLevel;
    private List<String> faultReasonList;
    private Integer faultReasonLevel;
    private List<String> gameNameList;
    private List<String> dataSourceList;
    private List<String> feedbackChannelList;
    private Map<String, List<String>> channelSourceMap;
    private List<String> emotionList;
    private String businessType;
    private List<String> productTypeList;
    private List<String> provinceIdList;
    private List<String> cityIdList;
    private List<String> sysVersionIdList;
    private List<String> fixDataRangeList;
    private List<String> areaList;
    private List<String> theaterList;
    private String startTime;
    private String endTime;
    private List<InternetBoardKeywordRuleEntity> keywordEntityList;
    private Integer isShowVocBoard = 1;
    private Integer containsNps;
    private Integer containsGameName;
}