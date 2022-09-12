//package com.stephen.jvm.learn.chapter05vmstack.bytecode;
//
//import java.lang.invoke.LambdaMetafactory;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Invoke {
//    //方法调用指令：invokespecial
//    public void invoke1() {
//        //情况1：类实例构造器方法：<init>()
//        Date date = new Date();
//        Thread t1 = new Thread();
//        //情况2：父类的方法
//        super.toString();
//        //情况3：私有方法
//        methodPrivate();
//    }
//    //方法调用指令：invokestatic
//    public void invoke2() {
//        methodstatic();
//        //0 invokestatic #2 <com/test/Demo.methodstatic>
//        //3 return
//    }
//
//    //方法调用指令：invokeinterface
//    public void invoke3() {
//        Thread t1 = new Thread();
//
//        ((Runnable) t1).run();
//        Comparable<Integer> com = null;
//        com.compareTo(123);
//
//        Comparable<Integer> n1= new Comparable<Integer>() {
//            @Override
//            public int compareTo(Integer o) {
//                return 0;
//            }
//        };
//        n1.compareTo(22);
//    }
//    //方法调用指令：invokedynamic
//    public void invoke4(){
//        Invoke invoke=new Invoke();
//        invoke.lambdaTest(str -> true);
//        invoke.lambdaTest(str -> true);
//    }
//
//    //方法调用指令：invokevirtual
//    public void invoke5(){
//        Invoke invoke=new Invoke();
//        invoke.invoke1();
//        invoke.invoke2();
//        invoke.invoke3();
//        invoke.invoke4();
//    }
//
//    public void lambdaTest(Func func){
//        return;
//    }
//
//
//    @FunctionalInterface interface Func {
//        public boolean func(String str);
//    }
//    private void methodPrivate() {}
//    private static void methodstatic() {}
//
//    public static void main(String[] args) {
//        Invoke invoke=new Invoke();
//        invoke.invoke4();
//    }
//
//}
