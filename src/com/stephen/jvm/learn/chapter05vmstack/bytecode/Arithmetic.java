package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Arithmetic {
    public void test() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j); // Infinity

        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2); // NaN
    }

    public void add(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=n1+n2;
        long a2=n3+n4;
        float a3=n5+n6;
        double a4=n7+n8;
    }

    public void sub(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=n1-n2;
        long a2=n3-n4;
        float a3=n5-n6;
        double a4=n7-n8;
    }

    public void mul(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=n1*n2;
        long a2=n3*n4;
        float a3=n5*n6;
        double a4=n7*n8;
    }

    /**
     * 除
     */
    public void div(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=n1/n2;
        long a2=n3/n4;
        float a3=n5/n6;
        double a4=n7/n8;
    }

    /**
     * 求余
     */
    public void rem(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=n1%n2;
        long a2=n3%n4;
        float a3=n5%n6;
        double a4=n7%n8;
    }

    /**
     * 取反,正变为负，负变为正，0不变
     */
    public void neg(){
        int n1=6554;
        int n2=6558;
        long n3=655450;
        long n4=655450;
        float n5=1.3f;
        float n6=1.4f;
        double n7=123.4;
        double n8=234.5;
        int a1=-n1;
        long a2=-n3;
        float a3=-n5;
        double a4=-n7;
    }

    /**
     * 自增 把一个常量值加到一个int类型的局部变量上
     * 对本地变量进行自增（+1）操作，与操作数栈无关
     * 先将本地变量表中n1加载至操作数栈中，
     * 再将本地变量表n1自增
     * 再将操作数栈顶数据出栈保存至本地变量表中
     */
    public void inc1(){
        int n1=6554;
        int m1= n1++;
    }

    /**
     * 自增 把一个常量值加到一个int类型的局部变量上
     * 先将本地变量表中n1自增
     * 再将本地变量表中n1加载至操作数栈中
     * 再将操作数栈顶数据出栈保存至本地变量表中
     */
    public void inc2(){
        int n1=6554;
        int m1= ++n1;
    }

    public void cmp(){
        int m=0;
        int n=1;
        int l=0;
        if(m>n){
            l=2;
        }
        if(m>=n){
            l=2;
        }
        if(m<n){
            l=2;
        }
        if(m<=n){
            l=2;
        }
        if(m==n){
            l=2;
        }
    }

    public static void main(String[] args) {
        int n1=6554;
        int m1= n1++;
        System.out.println(n1);
        System.out.println(m1);
    }
}
