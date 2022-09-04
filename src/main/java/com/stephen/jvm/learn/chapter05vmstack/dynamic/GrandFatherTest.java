package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class GrandFatherTest {
    public static void main(String[] args) {
        GrandFather grandFather=new Son();
        grandFather.thinking();
    }
}
class GrandFather {
    void thinking() {
        System.out.println("i am grandfather");
    }
}
class Father extends GrandFather {
    void thinking() {
        System.out.println("i am father");
    }
}
class Son extends Father {
    void thinking() {
        // 请读者在这里填入适当的代码（不能修改其他地方的代码）
        // 实现调用祖父类的thinking()方法，打印"i am grandfather"
        try {
            MethodType methodType=MethodType.methodType(void.class);
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle methodHandle = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class,"thinking",methodType,GrandFather.class);
            methodHandle.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}