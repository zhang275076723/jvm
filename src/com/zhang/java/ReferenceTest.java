package com.zhang.java;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author zsy
 * @Create 2020/3/20 22:49
 * @Description
 */
public class ReferenceTest {
    public static void main(String[] args) {
//        reference();
//        softReference();
//        weakReference();
//        weakHashMap();
        phantomReference();
    }

    public static void reference() {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.println(o1);
        System.out.println(o2);

        o1 = null;
        System.gc();
        System.out.println("==================");

        System.out.println(o1);
        System.out.println(o2);
    }

    public static void softReference() {
        Object o1 = new Object();
        Reference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

//        o1 = null;
//        System.gc();
//        System.out.println("==================");
//
//        System.out.println(o1);
//        System.out.println(softReference.get());

        o1 = null;
        try {
            Byte[] bytes = new Byte[20 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void weakReference() {
        Object o1 = new Object();
        Reference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("==================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }

    public static void weakHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        Integer k1 = new Integer(1);
        String v1 = "HashMap";
        hashMap.put(k1, v1);
        System.out.println(hashMap);

        k1 = null;
        System.out.println(hashMap);

        System.gc();
        System.out.println(hashMap);

        System.out.println("==================");

        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer k2 = new Integer(2);
        String v2 = "WeakHashMap";
        weakHashMap.put(k2, v2);
        System.out.println(weakHashMap);

        k2 = null;
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap);
    }

    public static void phantomReference() {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("==================");

        o1 = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
