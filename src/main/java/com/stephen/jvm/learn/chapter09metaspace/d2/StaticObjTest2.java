package com.stephen.jvm.learn.chapter09metaspace.d2;

/**
 * 《深入理解Java虚拟机》中的案例：
 * staticObj、instanceObj、localObj存放在哪里？
 * @author Stephen  Stephen@126.com
 * @create 2020  11:39
 */
public class StaticObjTest2 {
    static ObjectHolder staticObj = new ObjectHolder();

    void foo() {
        staticObj.toString();
        System.out.println("done");//这里设置一个断点
        try {
            Thread.sleep(1000*10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) throws InterruptedException {
        StaticObjTest2 test = new StaticObjTest2();
        test.foo();
    }
}
