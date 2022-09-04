package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
public class InvokeDynamicTest {
    public static void main(String[] args) throws Throwable {
        MH_BootstrapMethod().invokeExact("icyfenix");
    }
    public static void testMethod(String s) {
        System.out.println("hello String:" + s);
    }
    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable{
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString(
                        "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String; Ljava/lang/invoke/MethodType;)",null);
    }
        private static MethodHandle MH_BootstrapMethod() throws Throwable {
            return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
        }
        private static MethodHandle INDY_BootstrapMethod() throws Throwable {
            CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                    MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
            return cs.dynamicInvoker();
        }
    }