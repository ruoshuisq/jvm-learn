package com.stephen.jvm.learn.chapter15gc.weakreference;

/**
 * 使用加锁的方式解决：线程间访问共享变量之间问题
 * 将对共享变量的操作进行加锁，保证其原子性
 * */
public class SolveDemoQuestionBySynchronized {
    private String name;
    private int age;

    public static void main(String[] args) {
        SolveDemoQuestionBySynchronized demoQuestion = new SolveDemoQuestionBySynchronized();
        for (int i = 0; i < 5; i++) {
            // int j = i;
            new Thread(() ->{
                synchronized (SolveDemoQuestionBySynchronized.class){
                    demoQuestion.setName(Thread.currentThread().getName() + "的数据");
                    System.out.println("=================");
                    System.out.println(Thread.currentThread().getName() + "--->" + demoQuestion.getName());
                }
            },"t" + i).start();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

