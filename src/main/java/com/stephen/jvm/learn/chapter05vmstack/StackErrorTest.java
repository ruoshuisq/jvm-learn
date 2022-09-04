package com.stephen.jvm.learn.chapter05vmstack;

/**
 * 演示栈中的异常:StackOverflowError
 * @author Stephen
 * @create 2020 下午 9:08
 *
 *  默认情况下：count : 11418
 *  设置栈的大小： -Xss256k : count : 2467
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }

}
