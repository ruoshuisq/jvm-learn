package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Cobra2Test {
    public static void main(String[] args) throws Throwable {
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodType methodType = MethodType.methodType(void.class);
//        MethodHandle methodHandle = lookup.findSpecial(Cobra2.class, "eat", methodType,Cobra2.class);
        Cobra2 cobra = new Cobra2();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodHandle methodHandle = lookup.findSetter(Cobra2.class, "name", String.class);
//        methodHandle.invokeExact(cobra,"111");
        MethodHandle setName = lookup.findVirtual(Cobra2.class, "setName", MethodType.methodType(void.class, String.class));
        setName.invokeExact(cobra,"lisi");
        MethodHandle getName = lookup.findVirtual(Cobra2.class, "getName", MethodType.methodType(String.class));
        String o = (String)getName.invokeExact(cobra);
        System.out.println(o);
        new Cobra2Test().bindTo();
    }

    public void bindTo()throws Throwable{
        MethodHandles.Lookup lookup=MethodHandles.lookup();
        //MethodHandle.bindTo使用
        MethodHandle methodHandle = lookup
                .findVirtual(String.class, "length", MethodType.methodType(int.class));
        int len = (int) methodHandle.invoke("java");
        System.out.println(len);
        methodHandle = methodHandle.bindTo("hello java");
        len = (int) methodHandle.invoke();
        System.out.println(len);
    }
}
