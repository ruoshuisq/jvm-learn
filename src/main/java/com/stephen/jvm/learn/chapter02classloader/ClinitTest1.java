package com.stephen.jvm.learn.chapter02classloader;

/**
 * @author Stephen
 * @create 2020 下午 8:40
 */
public class ClinitTest1 {
    static class Father{
        public static int A = 1;
        static{
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    static int a=2;

    public static void main(String[] args) {
        //加载Father类，其次加载Son类。
        System.out.println(Son.B);//2
        int f1 = Father1.f1;
    }
}
interface Father1{
    static int f1=1;
    void method1();
}
interface Father2{
    static int f2=2;
    void method2();
}
