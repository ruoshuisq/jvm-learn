package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.*;


public class CallSiteTest {
    /**
     * 表示的调用点绑定的是一个固定的方法句柄，一旦链接之后，就无法修改
     * @throws Throwable
     */
    public static void constantCallSite() throws Throwable {
        MethodType methodType = MethodType.methodType(void.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Horse horse = new Horse();
        MethodHandle methodHandle = lookup.findVirtual(horse.getClass(), "race", methodType);

        ConstantCallSite callSite = new ConstantCallSite(methodHandle);
        MethodHandle invoker = callSite.dynamicInvoker();
        invoker.invoke(horse);
    }

    /**
     * MutableCallSite 允许对其所关联的目标方法句柄通过setTarget方法来进行修改。
     * 以下为 创建一个 MutableCallSite，指定了方法句柄的类型，则设置的其他方法也必须是这种类型。
     */
    public static void useMutableCallSite() throws Throwable {
        MethodType type = MethodType.methodType(void.class);
        MutableCallSite callSite = new MutableCallSite(type);
        MethodHandle invoker = callSite.dynamicInvoker();

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        //    MethodHandle horseMethodHandle = lookup.findVirtual(Horse.class, "race", type);
        MethodHandle horseMethodHandle = lookup.findStatic(Horse.class,"say",type);
        callSite.setTarget(horseMethodHandle);
        invoker.invoke();

        MethodHandle minHandle = lookup.findStatic(Cobra.class, "race", type);
        callSite.setTarget(minHandle);
        invoker.invoke();
    }

    public static void main(String[] args) throws Throwable {
        CallSiteTest.constantCallSite();
        CallSiteTest.useMutableCallSite();
    }
}
class Horse {

    public static void say() {
        System.out.println("Horse.say()");
    }

    public void race() {
        System.out.println("Horse.race()");
    }
}
class Cobra {

    public static void race() {
        System.out.println("race");
    }
}