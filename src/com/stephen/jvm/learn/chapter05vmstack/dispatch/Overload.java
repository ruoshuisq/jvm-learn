package com.stephen.jvm.learn.chapter05vmstack.dispatch;

import java.io.Serializable;

/**
 * 重载方法匹配优先级
 * @BelongsProject: jvm-learn
 * @BelongsPackage: com.stephen.jvm.learn.chapter05vmstack.dispatch
 * @Author: stephen
 * @CreateTime: 2022-09-02  10:51
 * @Description: 重载方法匹配优先级
 * @Version: 1.0
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }
    public static void sayHello(int arg) {
        System.out.println("hello int");
    }
    public static void sayHello(long arg) {
        System.out.println("hello long");
    }
    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }
    public static void sayHello(char arg) {
        System.out.println("hello char");
    }
    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }
    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }
    public static void main(String[] args) {
        sayHello('a');
    }
}
