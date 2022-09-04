package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.Lookup;

public class Cobra1 {
    public static void race() {
        System.out.println("race");
    }

    public static Lookup lookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = Cobra1.lookup();
        Method method = Cobra1.class.getDeclaredMethod("race");
        MethodHandle methodHandle = lookup.unreflect(method);
    }
}
