package com.stephen.jvm.learn.chapter05vmstack.d3;

public class UnVirtualMethod {

    public UnVirtualMethod(){

    }

    public static void method1(){

    }

    private void method2(){

    }

    public final void method3(){

    }

    public void method4(){
        super.toString();
    }

    public static void main(String[] args) {
        String s ="abc";
        UnVirtualMethod unVirtualMethod=new UnVirtualMethod();
        method1();
        unVirtualMethod.method2();
        unVirtualMethod.method3();
        unVirtualMethod.method4();
    }

}
