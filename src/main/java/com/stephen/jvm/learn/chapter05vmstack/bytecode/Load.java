package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Load {

    // 1 局部变量入栈命令
    public void load1(int num,Object obj,long count,boolean flag,short[] arr){
        System.out.println(num);
        System.out.println(obj);
        System.out.println(count);
        System.out.println(flag);
        System.out.println(arr);
    }

    public static void test1(int... a){

    }
    public static void test2(int a,long b,float c,double d,String s){

    }

    public static void load2(){
        int i1=0;
        int i2=0;
        int i3=0;
        int i4=0;
        int i5=0;
        test1(i1,i2,i3,i4,i5);
    }

    public static void load3(){
        int i1=0;
        long i2=0;
        float i3=0;
        double i4=0;
        String i5="";
        test2(i1,i2,i3,i4,i5);
    }

}
