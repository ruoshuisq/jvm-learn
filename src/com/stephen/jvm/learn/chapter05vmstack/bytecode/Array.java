package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Array {

    public void text() {
        int[] intArray = new int[10];
        intArray[3] = 20;
        System.out.println(intArray[5]);
        boolean [] booleanArray = new boolean[10];
        booleanArray[3]=true;
        System.out.println(booleanArray[5]);
        int n=booleanArray.length;
    }

}
