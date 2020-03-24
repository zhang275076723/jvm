package com.zhang.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author zsy
 * @Create 2020/3/7 13:06
 * @Description
 */
public class MyObject {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
        List list = new ArrayList();
        System.out.println(list.getClass());
        System.out.println(list.getClass().getClass());
//        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

}
