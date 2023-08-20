package com.itender.newfeature.lambdaobj;

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
    private final Map<String, Function<User, String>> grantTypeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        grantTypeMap.put("张三", (User user) -> grantTypeService.redPaper(user));
        grantTypeMap.put("李四", (User user) -> grantTypeService.shopping(user));
        grantTypeMap.put("王五", (User user) -> grantTypeService.QQVip(user));
    }

    public String getResult(User user) {
        Function<User, String> result = grantTypeMap.get("张三");
        if (Objects.nonNull(result)) {
            return result.apply(user);
        }
        return "查询不到该方式";
    }
}
