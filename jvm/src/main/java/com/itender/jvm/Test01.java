package com.itender.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-16 19:21
 */
public class Test01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
