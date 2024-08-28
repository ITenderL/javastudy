package com.itender.interview.thread.game;


import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author itender
 * @date 2023/12/08/ 14:34
 * @desc
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    /**
     * 声明不同方向的蛇头
     */
    ImageIcon right = new ImageIcon("interview/src/main/resources/images/right.png");
    ImageIcon left = new ImageIcon("interview/src/main/resources/images/left.png");
    ImageIcon up = new ImageIcon("interview/src/main/resources/images/up.png");
    ImageIcon down = new ImageIcon("interview/src/main/resources/images/down.png");
    /**
     * 声明食物的图片
     */
    ImageIcon food = new ImageIcon("interview/src/main/resources/images/food.png");


    /**
     * 声明蛇的身体
     */
    ImageIcon body = new ImageIcon("interview/src/main/resources/images/body.png");

    /**
     * 蛇的初始长度
     */
    private int length = 3;

    /**
     * 两个数组分别存储蛇的x和y的坐标位置 最大值 = 格子宽 * 格子长
     */
    int[] snakeX = new int[1008];
    int[] snakeY = new int[1008];

    /**
     * 蛇头初始化时的方向
     */
    Direction direction = Direction.RIGHT;

    /**
     * 是否开始  false: 未开始  true：开始
     */
    boolean started = false;

    /**
     * ①创建一个定时器Timer，
     * 第一个参数为多长时间比如：100毫秒，
     * 第二个参数当时间到了以后找谁-this，this需要实现ActionListener接口，
     * 重写actionPerformed()方法，也就是当时间到了调用actionPerformed()方法。
     */
    Timer timer = new Timer(100, this);

    // 生成的food的x和y坐标
    int foodX;
    int foodY;
    // 生成一个随机数
    Random random = new Random();

    public GamePanel() {
        // 定义蛇的初始值
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        // 设置获取焦点为true
        this.setFocusable(true);
        // 添加监听器
        this.addKeyListener(this);
        // 启动定时器
        timer.start();
        // 生成foodx和foody坐标
        foodX = 25 + 25 * random.nextInt(20);
        foodY = 25 + 25 * random.nextInt(20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 调用父类值的方法
        super.paintComponent(g);
        // 设置背景色
        this.setBackground(Color.red);
        // 在画布中设置游戏区域
        g.fillRect(0, 0, 700, 800);

        // 在画布中添加静态蛇头和身体
        // right.paintIcon(this, g, 100, 100);
        // body.paintIcon(this, g, 75, 100);
        // body.paintIcon(this, g, 50, 100);

        // 添加蛇头和蛇的身体 0 动态
        // right.paintIcon(this, g, snakeX[0], snakeY[0]);
        switch (direction) {
            case UP:
                up.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case DOWN:
                down.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case LEFT:
                left.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case RIGHT:
                right.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            default:
                break;
        }
        // 初始化蛇的身体，从下标1开始
        for (int i = 1; i < length; i++) {
            body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (!started) {
            // 设置开始提示
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑", Font.BOLD, 50));
            g.drawString("请按空格键开始游戏！", 50, 500);
        }

        // 添加food
        food.paintIcon(this, g, foodX, foodY);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // 空格键是32，如果是32，表示开始，或者暂停，
        // 下面为控制蛇的方向
        if (keyCode == 32) {
            started = !started;
            // 重画组件
            repaint();
        } else if (keyCode == KeyEvent.VK_UP && direction != Direction.DOWN) {
            direction = Direction.UP;
        } else if (keyCode == KeyEvent.VK_DOWN && direction != Direction.UP) {
            direction = Direction.DOWN;
        } else if (keyCode == KeyEvent.VK_LEFT && direction != Direction.RIGHT) {
            direction = Direction.LEFT;
        } else if (keyCode == KeyEvent.VK_RIGHT && direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 移动
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!started) {
            return;
        }
        // 平移身体，移动数组下标，后一个向前一个移动
        for (int i = length - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        // 蛇头移动，每次移动当前值+25
        // snakeX[0] += 25;
        // 如果蛇头超出700，则x的值从0重新开始
        // if (snakeX[0] > 700) {
        //     snakeX[0] = 0;
        // }
        // 根据方向direction移动蛇的头和身体
        switch (direction) {
            // 向右移动，y轴不变，x轴+25
            case RIGHT:
                snakeX[0] += 25;
                if (snakeX[0] >= 700) {
                    snakeX[0] = 0;
                    // int result = JOptionPane.showConfirmDialog(null, "Game over! Try again?", "Information", JOptionPane.YES_NO_OPTION);
                    // if (result == JOptionPane.YES_NO_OPTION) {
                    //
                    // }
                    // return;
                    // throw new RuntimeException("Game Over！");
                }
                break;
            // 向左移动，y轴不变，x轴-25
            case LEFT:
                snakeX[0] -= 25;
                if (snakeX[0] <= 0) {
                    snakeX[0] = 700;
                }
                break;
            // 向上移动，x轴不变，y轴-25
            case UP:
                snakeY[0] -= 25;
                if (snakeY[0] <= 0) {
                    snakeY[0] = 800;
                }
                break;
            // 向下移动，x轴不变，y轴+25
            case DOWN:
                snakeY[0] += 25;
                if (snakeY[0] >= 800) {
                    snakeY[0] = 0;
                }
                break;
            default:
                break;
        }
        // 蛇吃到食物，当蛇头的横坐标和纵坐标等于食物的横坐标和纵坐标，说明蛇吃到食物，长度增加，然后随机生成食物
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            length++;
            // 生成foodx和foody坐标
            foodX = 25 + 25 * random.nextInt(20);
            foodY = 25 + 25 * random.nextInt(20);
        }
        // 重画组件
        repaint();
        // 重新启动定时器
        timer.start();
    }

    @Getter
    public enum Direction {
        /**
         * 蛇移动方向枚举
         */
        UP(1, "上"),
        DOWN(2, "下"),
        LEFT(3, "左"),
        RIGHT(4, "右");

        private final Integer code;

        private final String description;

        Direction(Integer code, String description) {
            this.code = code;
            this.description = description;
        }
    }
}
