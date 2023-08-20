package com.itender.newfeature;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InternetBoardKeywordRuleEntity implements Serializable {

    private static final long serialVersionUID = 2701670005876224267L;

    /**
     * 包含must/不包含mustNot
     */
    private String mustOrMustNot;

    /**
     * 关键词集合，多个关键词为或的关系
     */
    private List<String> keywordList;
}