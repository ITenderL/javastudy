package com.itender.interview.thread.game;

import javax.swing.*;

/**
 * @author itender
 * @date 2023/12/08/ 14:25
 * @desc
 */
public class GluttonousSnake {
    public static void main(String[] args) {
        // 创建一个窗口
        JFrame jFrame = new JFrame();
        // 设置窗口的指定位置x和y的相对位置，窗口的宽度和高度
        jFrame.setBounds(500, 25, 700, 800);
        // 设置窗口不允许拖拽改变大小
        jFrame.setResizable(false);
        // 当窗口点击关闭按钮执行操作是退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 添加画布
        jFrame.add(new GamePanel());
        // 显示当前窗口
        jFrame.setVisible(true);
    }
}
