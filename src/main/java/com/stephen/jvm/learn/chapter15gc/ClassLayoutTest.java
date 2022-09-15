package com.stephen.jvm.learn.chapter15gc;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 测试对象头信息
 */
public class ClassLayoutTest {
    //-XX:-UseCompressedClassPointers
    //-XX:-UseCompressedOops
    @Test
    public void test1(){
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
        System.gc();
        System.out.println(layout.toPrintable());
        synchronized (obj){
            System.out.println(layout.toPrintable());
        }
    }
//-XX:-UseCompressedClassPointers -XX:-UseCompressedOops
//取消偏向锁延时
//-XX:BiasedLockingStartupDelay=0
//关闭偏向锁
//-XX:-UseBiasedLocking
//开启偏向锁
//-XX:+UseBiasedLocking
    public static void main(String[] args) throws InterruptedException {
//        Object obj = new Object();
//        ClassLayout layout = ClassLayout.parseInstance(obj);
//        System.out.println(layout.toPrintable());
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println(layout.toPrintable());
//        System.gc();
//        System.out.println(layout.toPrintable());
//        synchronized (obj){
//            System.out.println(layout.toPrintable());
//        }
//        closeCompressed();
//        nolock();
//        biasedLock();
//        cancelDelayBiasedLock();
//        closeBiasedLock();
//        biasedLockSync();
//        biasedLockHashCode();
//        lightWeightBiasedLock();
        weightBiasedLock();
    }
    //查看jdk是否指针压缩 java -XX:+PrintFlagsFinal -version | findstr UseCompressed
    //关闭指针压缩 -XX:-UseCompressedClassPointers -XX:-UseCompressedOops
    public static void closeCompressed() throws InterruptedException {
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
    }

    //锁升级
    //无锁 01
    public static void nolock(){
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
    }
    //偏向锁 101
    //查看jdk偏向锁相关参数 java -XX:+PrintFlagsFinal -version | findstr BiasedLocking
    //默认情况下偏向锁开启并且延时4s生效
    public static void biasedLock() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
    }
    //取消偏向锁延时 -XX:BiasedLockingStartupDelay=0
    public static void cancelDelayBiasedLock() throws InterruptedException {
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
    }

    //关闭偏向锁 -XX:-UseBiasedLocking
    //开启偏向锁 -XX:+UseBiasedLocking
    public static void closeBiasedLock() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
    }

    //偏向模式获取锁 取消进入偏向模式延迟后，加锁的过程 -XX:BiasedLockingStartupDelay=0
    public static void biasedLockSync() throws InterruptedException {
        Object obj = new Object();
        synchronized (obj){
            ClassLayout layout = ClassLayout.parseInstance(obj);
            System.out.println(layout.toPrintable());
        }
    }
    //偏向模式计算hashcode 计算hashcode后会立刻退出偏向模式 -XX:BiasedLockingStartupDelay=0
    public static void biasedLockHashCode() throws InterruptedException {
        Object obj = new Object();
        ClassLayout layout = ClassLayout.parseInstance(obj);
        System.out.println(layout.toPrintable());
        obj.hashCode();
        System.out.println(layout.toPrintable());
    }

    //轻量级锁 00 关闭偏向锁后，返回00代表轻量级锁开启 -XX:-UseBiasedLocking
    public static void lightWeightBiasedLock() throws InterruptedException {
        Object obj = new Object();
        synchronized (obj){
            ClassLayout layout = ClassLayout.parseInstance(obj);
            System.out.println(layout.toPrintable());
        }
    }
    //重量级锁 10 两个线程同时竞争膨胀为重量级锁
    public static void weightBiasedLock() throws InterruptedException {
        Object obj = new Object();
        for(int i=0;i<2;i++){
            new Thread(() -> {
                synchronized (obj){
                    ClassLayout layout = ClassLayout.parseInstance(obj);
                    System.out.println(layout.toPrintable());
                }
            }).start();
        }
    }

}
