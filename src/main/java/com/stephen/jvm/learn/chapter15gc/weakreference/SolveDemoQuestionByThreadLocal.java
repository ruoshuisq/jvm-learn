package com.stephen.jvm.learn.chapter15gc.weakreference;

public class SolveDemoQuestionByThreadLocal {
    private  ThreadLocal<String> name = new ThreadLocal<>();
    private int age;

    public static void main(String[] args) {
        SolveDemoQuestionByThreadLocal demoQuestion = new SolveDemoQuestionByThreadLocal();
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                demoQuestion.setName(Thread.currentThread().getName() + "的数据");
                System.out.println("=================");
                System.out.println(Thread.currentThread().getName() + "--->" + demoQuestion.getName());
            },"t" + i).start();
        }
    }
    public String getName() {
        return name.get();
    }
    private void setName(String content) {
        name.set(content);
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

