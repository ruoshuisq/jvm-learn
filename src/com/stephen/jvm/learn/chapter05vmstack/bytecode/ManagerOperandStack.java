package com.stephen.jvm.learn.chapter05vmstack.bytecode;

import java.util.Date;

public class ManagerOperandStack {

    public void pop(){
        System.console();
    }

    public void pop2(){
        System.currentTimeMillis();
    }

    public void dup(){
        int x;
        int y = x = 2;
        new Date();
    }

    public void swap(){
        int m=0;
        int n=1;
        int tmp=m;
        m=n;
        n=tmp;

    }

}
