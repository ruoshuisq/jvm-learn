package com.stephen.jvm.learn.chapter05vmstack.dispatch;

/**
 * 单分派、多分派演示
 * 动态分派属于单分派类型
 * 如今（直至编写的Java 12和预览版的Java 13）的Java语言是一门静态多分派、动态单分派的语言
 * 虚方法表
 */
public class Dispatch {
    static class QQ {}
    static class _360 {}
    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }
        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }
    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
