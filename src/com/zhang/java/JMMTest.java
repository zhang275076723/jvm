package com.zhang.java;

import java.util.concurrent.TimeUnit;

/**
 * @Author zsy
 * @Create 2020/3/13 9:28
 * @Description
 */
public class JMMTest {
    public static void main(String[] args) {
        A a = new A();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                a.changeNum();
                System.out.println(Thread.currentThread().getName() + ":" + a.getNum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();
        while (a.getNum() == 0) {

        }
        System.out.println("通知了:" + a.getNum());
    }
}

class A {
    private volatile int num = 0;

    public void changeNum() {
        num = 1;
    }

    public int getNum() {
        return num;
    }
}