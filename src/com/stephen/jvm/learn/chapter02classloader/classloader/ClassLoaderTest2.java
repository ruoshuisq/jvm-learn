package com.stephen.jvm.learn.chapter02classloader.classloader;

/**
 * @author Stephen
 * @create 2020 上午 10:59
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            //1.通过类加载器
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //2.线程获取
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            //3.获取系统类加载器
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
