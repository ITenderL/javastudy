package com.itender;

import com.itender.entity.UserEntity;
import org.apache.lucene.util.RamUsageEstimator;

/**
 * @author analytics
 * @date 2024/8/11 13:19
 * @description
 */
public class ObjectSizeDemo {
    public static void main(String[] args) {
        long longSize = RamUsageEstimator.sizeOf(new UserEntity());
        String size = RamUsageEstimator.humanSizeOf(new UserEntity());
        System.out.println(longSize + " " + size);
    }
}
