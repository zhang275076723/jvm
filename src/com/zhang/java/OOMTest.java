package com.zhang.java;


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zsy
 * @Create 2020/3/21 10:50
 * @Description
 */
public class OOMTest {
    public static void main(String[] args) {
//        stackOverFlowError();
//        javaHeapSpace();
//        gcOverhead();
//        directBufferMemory();
//        unableToCreateNewNativeThread();

    }

    public static void stackOverFlowError() {
        stackOverFlowError();
    }

    public static void javaHeapSpace() {
        Byte[] bytes = new Byte[20 * 1024 * 1024];
    }

    public static void gcOverhead() {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(++i + "");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void directBufferMemory() {
        System.out.println("配置的maxDirectMemory:" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

    public static void unableToCreateNewNativeThread() {
        int i = 1;
        while (true) {
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
            System.out.println("线程" + i++);
        }
    }

    public static void Metaspace() {

    }
}
