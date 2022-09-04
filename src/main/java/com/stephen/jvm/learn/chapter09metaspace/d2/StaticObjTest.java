package com.stephen.jvm.learn.chapter09metaspace.d2;

/**
 * 《深入理解Java虚拟机》中的案例：
 * staticObj、instanceObj、localObj存放在哪里？
 * @author Stephen  Stephen@126.com
 * @create 2020  11:39
 */
public class StaticObjTest {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");//这里设置一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.foo();
    }
}
