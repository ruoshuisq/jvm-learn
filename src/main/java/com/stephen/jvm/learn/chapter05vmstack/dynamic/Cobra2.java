package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.Lookup;

public class Cobra2 {
    public static void race() {
    }

    public void say(){
        System.out.println("say");
    }

    private void eat(){
        System.out.println("eat");
    }

    public String sayHello(Integer num){
        return "hello"+num;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Lookup lookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = Cobra2.lookup();
        MethodType methodType = MethodType.methodType(void.class);
        MethodHandle methodHandle = lookup.findStatic(Cobra2.class, "race", methodType);
        Cobra2 cobra2=new Cobra2();
        methodHandle.invokeExact();

        MethodHandle methodHandle2 = lookup.findVirtual(Cobra2.class, "say", methodType);
        methodHandle2.invokeExact(cobra2);

        MethodHandle eat = lookup.findSpecial(Cobra2.class, "eat", methodType,Cobra2.class);
        eat.invokeExact(cobra2);
        MethodHandle name = lookup.findSetter(Cobra2.class, "name", String.class);
        name.invokeExact(cobra2,"zhangsan");
        MethodHandle name1 = lookup.findGetter(Cobra2.class, "name", String.class);
        String o = (String) name1.invokeExact(cobra2);
        System.out.println(o);
        MethodHandle sayHello = lookup.findVirtual(Cobra2.class, "sayHello", MethodType.methodType(String.class,Integer.class));
        String o1 = (String)sayHello.invokeExact(cobra2, new Integer(10));
        System.out.println(o1);

    }
}
