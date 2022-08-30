package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Push {

    public void pushConstLdc() {
        int i = -1;
        int a = 5;
        int b = 6;
        int c = 127;
        int d = 128;
        int e = 32767;
        int f = 32768;
    }

    public void iconst(){
        int i=0;
        long l=0;
        float f=0;
        double d=0;
        String s=null;
    }

    public void push(){
        int i=127;
        int j=32767;
    }

    public void ldc(){
        int i =32768;
        long l =2;
        float f =3;
        double d =2;
        String s = "";
        double dw = 123456789012345.0;
    }


}
