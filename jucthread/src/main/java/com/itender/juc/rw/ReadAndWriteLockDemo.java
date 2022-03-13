package com.itender.juc.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-22 18:16
 * @Description: ReadAndWriteLock 读写锁
 *               读-读   可以共存
 *               读-写   不可以共存
 *               写-写   不可以共存
 */
public class ReadAndWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        // 写入
        for (int i = 1; i <= 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.put(tmp + "", tmp + "");
            }).start();
        }

        // 读取
        for (int i = 1; i <= 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.get(tmp + "");
            }).start();
        }
    }
}

/**
 * 自定义缓存类枷锁
 */
class MyCacheLock{
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入OK!" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取：" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取OK!" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}


/**
 * 自定义缓存类
 */
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入：" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " 写入OK!" );
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + " 读取：" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取OK!" );
    }
}
