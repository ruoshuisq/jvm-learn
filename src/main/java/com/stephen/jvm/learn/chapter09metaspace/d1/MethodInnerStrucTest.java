package com.stephen.jvm.learn.chapter09metaspace.d1;

import java.io.Serializable;

/**
 * 测试方法区的内部构成
 * @author Stephen  Stephen@126.com
 * @create 2020  23:39
 */
public class MethodInnerStrucTest extends Object implements Comparable<String>,Serializable {
    //属性
    public int num = 10;
//    private static String str = "测试方法的内部结构";
//    static{
//        String str2="静态域";
//    }
    public final static String str = "测试方法的内部结构";

    public static void test3(){
        int count = 20;
        String s=new StringBuilder().append("count = ").append(count).toString();
        System.out.println(s);
        System.out.println("count = " + count);
        test2(count);
        MethodInnerStrucTest o=new MethodInnerStrucTest();
        test4(o);
        MethodAreaDemo o2=new MethodAreaDemo();
        MethodAreaDemo.test1(o2);
        MethodAreaDemo.str.trim();
    }
    //构造器
    //方法
    public void test1(){
        int count = 20;
        System.out.println("count = " + count);
    }
    public static int test2(int cal){
        int result = 0;
        try {
            int value = 30;
            result = value / cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void test4(MethodInnerStrucTest o){

    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
