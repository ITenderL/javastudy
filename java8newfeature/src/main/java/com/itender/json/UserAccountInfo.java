package com.itender.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author yuanhewei
 * @date 2024/1/19 16:13
 * @description
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountInfo {

    private String platform;

    // @JSONField(name = "accArray")
    // @JsonProperty("acc_array")
    private List<String> accArray;
}
