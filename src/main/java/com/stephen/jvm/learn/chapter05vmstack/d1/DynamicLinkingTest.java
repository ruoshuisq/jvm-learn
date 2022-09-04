package com.stephen.jvm.learn.chapter05vmstack.d1;

/**
 * @author Stephen
 * @create 2020 下午 10:25
 */
public class DynamicLinkingTest {

    int num = 10;

    public void methodA(){
        System.out.println("methodA()....");
    }

    public void methodB(){
        System.out.println("methodB()....");

        methodA();

        num++;
    }

}
