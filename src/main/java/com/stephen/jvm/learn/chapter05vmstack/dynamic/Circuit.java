package com.stephen.jvm.learn.chapter05vmstack.dynamic;

import java.lang.invoke.*;

public class Circuit {

    public static void startRace(Object obj) {
    }

    public static void main(String[] args) {
        startRace(new Horse2());
    }

    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType callSiteType)
            throws Throwable {
        MethodHandle mh = l.findVirtual(Horse2.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callSiteType));
    }
}

class Horse2 {

    public void race() {
        System.out.println("Horse.race()");
    }
}
