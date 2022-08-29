package com.stephen.jvm.learn.chapter05vmstack;

public class ByteCode {

    /**
     * 1、将局部变量表中的变量压入操作数栈中
     * xload_<n>（x 为 i、l、f、d、a，n 默认为 0 到 3），表示将第 n 个局部变量压入操作数栈中。
     * xload（x 为 i、l、f、d、a），通过指定参数的形式，将局部变量压入操作数栈中，当使用这个指令时，表示局部变量的数量可能超过了 4 个
     * x 为操作码助记符，表明是哪一种数据类型
     * @param age
     * @param name
     * @param birthday
     * @param sex
     */
    public void load(int age, String name, long birthday, boolean sex) {
        System.out.println(age + name + birthday + sex);
    }

    public void pushConstLdc() {
        // 范围 [-1,5]
        int iconst = -1;
        // 范围 [-128,127]
        int bipush = 127;
        // 范围 [-32768,32767]
        int sipush= 32767;
        // 其他 int
        int ldc = 32768;
        String aconst = null;
        String IdcString = "沉默王二";
    }

    public void store(int age, String name) {
        int temp = age + 2;
        String str = name;
    }
}
