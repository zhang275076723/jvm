package com.zhang.java;

import java.util.Random;

/**
 * @Author zsy
 * @Create 2020/3/22 16:00
 * @Description
 */
public class GCTest {
    public static void main(String[] args) {
        try {
            String str = "hello";
            while (true) {
                str += str + new Random().nextInt(1000000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
