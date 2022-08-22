package com.stephen.jvm.learn.chapter02classloader.classloader;

/**
 * @author Stephen
 * @create 2020 上午 11:39
 */
public class StringTest {
//双亲委派机制
    public static void main(String[] args) {
        java.lang.String str = new java.lang.String();
        System.out.println("hello,atguigu.com");

        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
