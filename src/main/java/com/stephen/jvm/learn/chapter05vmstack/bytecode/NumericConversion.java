package com.stephen.jvm.learn.chapter05vmstack.bytecode;

import org.junit.Test;

public class NumericConversion {

    /**
     * 宽化类型转换
     */
    public void wideningNumericConversion(){
        int i = 10;
        long l = i; // i2l
        float f = i; // i2f
        double d = i; // i2d

        float f1 = l; // l2f
        double d1 = l; // l2d
        double d2 = f1; // f2d
    }
    @Test
    public void upCast2() {
        int i = 123123123;
        float f = i;
        System.out.println(f); // 1.2312312E8 = 123123120 精度丢失
        long l = 123123123123123123L; //1.2312312312312312E17
        double d = l; //123123123123123120 精度丢失
        System.out.println(d);
    }

    public void downCastl() {
        int i = 10;
        byte b = (byte) i; // i2b
        short s = (short) i; // i2s
        char c = (char) i; // i2c
        long l = 10L;
        int il = (int) l; // l2i
        byte b1 = (byte) l; // l2i i2b
    }

    public void downCast2() {
        float f = 10;
        long l = (long) f; // f2l
        int i = (int) f; // f2i
        byte b = (byte) f; // f2i i2b
        double d = 10;
        byte b1 = (byte) d; // d2i i2b
    }
}
