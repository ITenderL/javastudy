package com.itender.spring.service.impl;

import com.itender.spring.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @author itender
 * @date 2022/5/20 14:19
 * @desc
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Spring Ioc Test!!!";
    }
}
