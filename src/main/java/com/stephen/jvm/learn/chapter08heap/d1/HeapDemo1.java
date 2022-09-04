package com.stephen.jvm.learn.chapter08heap.d1;

/**
 * -Xms20m -Xmx20m
 * @author Stephen  Stephen@126.com
 * @create 2020  16:42
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
