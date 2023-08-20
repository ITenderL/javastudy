package com.itender.jvm;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-16 19:21
 */
@Slf4j
public class BytesOfObject {
    public static void main(String[] args) {
        Object o = new Object();
        log.info(ClassLayout.parseInstance(o).toPrintable());
    }
}
