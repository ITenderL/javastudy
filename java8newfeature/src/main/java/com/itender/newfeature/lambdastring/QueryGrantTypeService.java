package com.itender.newfeature.lambdastring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author itender
 * @date 2022/6/13 17:08
 * @desc
 */
@Service
public class QueryGrantTypeService {
    @Autowired
    private GrantTypeService grantTypeService;
    private final Map<String, Function<String, String>> grantTypeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        grantTypeMap.put("redPaper", resourceId -> grantTypeService.redPaper(resourceId));
        grantTypeMap.put("shopping", resourceId -> grantTypeService.shopping(resourceId));
        grantTypeMap.put("qqVip", resourceId -> grantTypeService.QQVip(resourceId));
    }

    public String getResult(String resourceId) {
        Function<String, String> result = grantTypeMap.get(resourceId);
        if (Objects.nonNull(result)) {
            return result.apply(resourceId);
        }
        return "查询不到该方式";
    }
}
