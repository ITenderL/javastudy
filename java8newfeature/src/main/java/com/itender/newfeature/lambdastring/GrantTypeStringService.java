package com.itender.newfeature.lambdastring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author itender
 * @date 2022/6/13 17:04
 * @desc
 */
@Slf4j
@Service
public class GrantTypeStringService {
    public String redPaper(String resourceId) {
        log.info("resourceId = {}", resourceId);
        return "每周末9点发放";
    }

    public String shopping(String resourceId) {
        log.info("resourceId = {}", resourceId);
        return "每周三9点发放";
    }

    public String QQVip(String resourceId) {
        log.info("resourceId = {}", resourceId);
        return "每周末一0点发放";
    }
}
