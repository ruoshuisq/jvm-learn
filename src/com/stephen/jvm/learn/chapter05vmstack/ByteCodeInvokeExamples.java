package com.stephen.jvm.learn.chapter05vmstack;

import java.util.ArrayList;
import java.util.List;

public class ByteCodeInvokeExamples {
    private void run() {
        List ls = new ArrayList();
        ls.add("难顶");

        ArrayList als = new ArrayList();
        als.add("学不动了");
    }

    public static void print() {
        System.out.println("invokestatic");
    }

    public static void main(String[] args) {
        print();
        ByteCodeInvokeExamples invoke = new ByteCodeInvokeExamples();
        invoke.run();
    }
}
