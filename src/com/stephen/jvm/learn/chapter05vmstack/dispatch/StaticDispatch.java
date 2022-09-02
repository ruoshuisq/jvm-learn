package com.stephen.jvm.learn.chapter05vmstack.dispatch;

import java.util.Random;

/**
 * 方法静态分派演示
 * @author zhaojiang
 * @createTime 2022/9/2-10:33
 * @Version 1.0
 */

public class StaticDispatch {
    static abstract class Human {
    }
    static class Man extends Human {
    }
    static class Woman extends Human {
    }
    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }
    //虚拟机（或者准确地说是编译器）在重载时是通过参数的静态类型而不是实际类型作为判定依据的
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        // 实际类型变化
        Human human = (new Random()).nextBoolean() ? new Man() : new Woman();
        // 静态类型变化
        sr.sayHello( human);
        sr.sayHello( human);
    }
}
