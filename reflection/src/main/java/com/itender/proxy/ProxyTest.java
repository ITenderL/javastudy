package com.itender.proxy;

/**
 * @author itender
 * @date 2023/3/20 15:15
 * @desc
 */
public class ProxyTest {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("鸡哥");
        Star star = ProxyUtils.createProxy(bigStar);
        System.out.println(star.sing("爱你在心口难开"));
        star.dance();
    }
}
