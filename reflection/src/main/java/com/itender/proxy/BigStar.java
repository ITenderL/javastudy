package com.itender.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author itender
 * @date 2023/3/20 14:53
 * @desc
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BigStar implements Star {

    /**
     * 名称
     */
    private String name;

    @Override
    public String sing(String singName) {
        System.out.println(name + ": 在唱歌" + singName);
        return "谢谢";
    }

    @Override
    public void dance() {
        System.out.println(name + ": 在跳舞");
    }
}
