package com.itender.io;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * @author itender
 * @date 2022/9/7 11:27
 * @desc
 */
@SpringBootTest
public class FileCreateTest {
    public static void main(String[] args) {

    }

    @Test
    void create1() {
        File file = new File("E:\\MyFile\\javaio\\create.txt");
        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
