package com.itender.newfeature.lambdaobj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author itender
 * @date 2022/6/13 17:04
 * @desc
 */
@Slf4j
@Service
public class GrantTypeService {
    public String redPaper(User user) {
        log.info("resourceId = {}", user);
        return "每周末9点发放";
    }

    public String shopping(User user) {
        log.info("resourceId = {}", user);
        return "每周三9点发放";
    }

    public String QQVip(User user) {
        log.info("resourceId = {}", user);
        return "每周末一0点发放";
    }
}
