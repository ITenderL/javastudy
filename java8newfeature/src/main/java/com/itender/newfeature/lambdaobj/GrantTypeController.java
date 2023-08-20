package com.itender.newfeature.lambdaobj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itender
 * @date 2022/6/13 17:13
 * @desc
 */
@RestController
public class GrantTypeController {

    @Autowired
    private QueryGrantTypeService queryGrantTypeService;

    @GetMapping("/grantType/{resourceId}")
    public String test(@PathVariable("resourceId") String resourceId) {
        return queryGrantTypeService.getResult(new User());
    }
}
