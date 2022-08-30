package com.stephen.jvm.learn.chapter09metaspace.d1;

/**
 *  测试设置方法区大小参数的默认值
 *
 *  jdk7及以前：
 *  -XX:PermSize=100m -XX:MaxPermSize=100m
 *
 *  jdk8及以后：
 *  -XX:MetaspaceSize=100m  -XX:MaxMetaspaceSize=100m
 *  元空间替代永久代的原因
 *  1、永久代大小设置很难确定
 *  在某些场景下，如果动态类加载过多，容易导致Perm区OOM。比如某个web工程中，因为功能点比较多，在运行过程中，要不断加载很多类，经常出现致命错误。
 *  而元空间和永久代最大的区别在于：元空间并不在虚拟机中，而是使用本地内存。默认情况下元空间大小仅受本地内存限制（-XX:MaxMetaspaceSize=-1）
 *  2、对永久代调优很困难
 *
 *  字符串常量池为何移植至堆中：在方法区回收频率较低；堆中回收频率较高，回收效率高，主要减少fullGC次数
 *
 *  JDK 7及其以后版本的HotSpot虚拟机选择把静态变量与类型在Java语言一端的映射Class对象存放在一起，存储于Java堆之中
 *  可参考https://openjdk.org/jeps/122
 * @author Stephen  Stephen@126.com
 * @create 2020  12:16
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start...");
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("end...");
    }

    public static void test1(MethodAreaDemo o){
        o.toString();
    }

    public static String str="";
}
