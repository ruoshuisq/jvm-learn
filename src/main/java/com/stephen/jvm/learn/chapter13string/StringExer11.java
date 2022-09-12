package com.stephen.jvm.learn.chapter13string;

import org.junit.Test;

/**
 * String的String Pool是一个固定大小的Hashtable。如果放进String Pool的String非常多，就会造成Hash冲突严重，
 * 从而导致链表会很长，而链表长了后直接会造成的影响就是当调用String.intern时性能会大幅下降。
 * 使用-XX:StringTableSize可设置StringTable的长度
 * 在jdk6中StringTable是固定的，就是1009的长度，所以如果常量池中的字符串过多就会导致效率下降很快，没有最大最小值限制。
 * 在jdk7中StringTable的长度默认值是60013,没有最小限制。
 * 在jdk8中StringTable的长度默认值是60013,最小限制：1009是可设置的最小值。
 *
 * StringTable jdk6放在方法区，jdk7放在堆中
 * StringTable为什么要调整？ 1、PermSize默认比较小；2、永久代垃圾回收频率低
 *
 */
public class StringExer11 {
    String str=new String("good");
    char[]ch = {'t','e','s','t'};
    Student student=new Student("zhangsan");
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='b';
    }

    public void change2(String str,char ch[],Student student){
        str="test ok";//相当于新建对象，局部变量表中变量地址指向新的对象，原来的对象未发生任何变动
        ch[0]='b';
        student=new Student("lisi");
//        student.name="lisi";
    }
    @Test
    public void test1(){
        change(str,ch);
        System.out.println(str);
        System.out.println(ch);
        change2(str,ch,student);
        System.out.println(student);
        Student student1=new Student("wangwu");
        change2(str,ch,student1);
        System.out.println(student1);
    }

    class Student{
        String name;
        public Student(String name){
            this.name=name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
