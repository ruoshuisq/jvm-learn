package com.stephen.jvm.learn.chapter08heap.d2;

/**
 * 测试-XX:+UseTLAB参数是否开启的情况:默认情况是开启的
 * jps
 * jinfo -flag UseTLAB 6880(pid)
 * @author Stephen  Stephen@126.com
 * @create 2020  16:16
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油~");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
