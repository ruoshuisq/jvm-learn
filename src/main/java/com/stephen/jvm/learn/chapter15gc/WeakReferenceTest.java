package com.stephen.jvm.learn.chapter15gc;

import java.lang.ref.WeakReference;

/**
 * 弱引用的测试
 *
 * @author shkstart  shkstart@126.com
 * @create 2020  16:06
 */
public class WeakReferenceTest {
    public static class User {
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "[id=" + id + ", name=" + name + "] ";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //构造了弱引用
        WeakReference<User> userWeakRef = new WeakReference<User>(new User(1, "songhk"));
        //从弱引用中重新获取对象
        System.out.println(userWeakRef.get());

        System.gc();
        // 不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After GC:");
        //重新尝试从弱引用中获取对象
        System.out.println(userWeakRef.get());
        ThreadLocal<User> threadLocal = new ThreadLocal<User>();
        User user = new User(2,"zhangsan");
        threadLocal.set(user);
        user=null;
        User user1 = threadLocal.get();
        System.out.println(user1);
        System.gc();
        Thread.sleep(1000);
        System.out.println(user1);
    }
}