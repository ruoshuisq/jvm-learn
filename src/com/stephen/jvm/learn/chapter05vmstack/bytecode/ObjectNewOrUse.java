package com.stephen.jvm.learn.chapter05vmstack.bytecode;

import java.io.File;

public class ObjectNewOrUse {

    public static int m=0;
    public int n=0;

    // 创建对象
    public void newInstance() {
        Object obj = new Object();

        File file = new File("Hello.txt");
    }

    // 创建数组
    public void newArray() {
        int[] intArray = new int[10]; // newarray
        Object[] objArray = new Object[20]; // anewarray
        int[][] mintArray = new int[30][40]; // multianewarray
        String[][] strArray = new String[50][]; // newarray
        String[][] strArray2 = new String[60][70]; // multianewarray
    }

    public void getField(){
        int mm=ObjectNewOrUse.m;
        ObjectNewOrUse.m=3;
        ObjectNewOrUse objectNewOrUse=new ObjectNewOrUse();
        int nn = objectNewOrUse.n;
        objectNewOrUse.n=3;
        nn=nn+mm;
    }
}
