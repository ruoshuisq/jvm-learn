package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Synchronized {
    public synchronized void test() {}
    private int i = 0;
    private Object obj = new Object();

    public void subtract() {
        synchronized (obj) {
            i--;
        }
    }
}
