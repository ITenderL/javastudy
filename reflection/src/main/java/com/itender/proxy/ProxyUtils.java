package com.itender.proxy;

import java.lang.reflect.Proxy;

/**
 * @author itender
 * @date 2023/3/20 14:59
 * @desc
 */
public class ProxyUtils {

    public static Star createProxy(BigStar bigStar) {
        // new InvocationHandler() {
        //     // 参数一：代理的对象
        //     // 参数二：要运行的方法 sing()
        //     // 参数三：嗲用代理方法sing()时要传递的实参
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         if ("sing".equals(method.getName())) {
        //             System.out.println("准备唱歌场地，收唱歌门票钱！");
        //         }else if("dance".equals(method.getName())) {
        //             System.out.println("准备跳舞场地，收跳舞门票钱！");
        //         }
        //         return method.invoke(bigStar, args);
        //     }
        // });
        // 第一个参数：指定用哪个类的加载器去加载生成的代理类
        // 第二个参数：指定接口，这些接口用于指定生成的代理生么，以为就是那些方法
        // 第三个参数：用来指定生成的代理对象要干什么事情
        return (Star) Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(),
                new Class[]{Star.class},
                // 参数一：代理的对象
                // 参数二：要运行的方法 sing()
                // 参数三：嗲用代理方法sing()时要传递的实参
                (proxy, method, args) -> {
                    if ("sing".equals(method.getName())) {
                        System.out.println("准备唱歌场地，收唱歌门票钱！");
                    } else if ("dance".equals(method.getName())) {
                        System.out.println("准备跳舞场地，收跳舞门票钱！");
                    }
                    return method.invoke(bigStar, args);
                });
    }
}
