package com.stephen.jvm.learn.chapter13string;

import org.junit.Test;

public class StringTest11
{
    @Test
    public void test1(){
        String s1="abc";//字面量的定义方式，“abc”存储在字符串常量池中
        String s2="abc";//字面量的定义方式，“abc”存储在字符串常量池中
        s1="hello";
        System.out.println(s1==s2);//false
    }

    @Test
    public void test2(){
        String s1="abc";//字面量的定义方式，“abc”存储在字符串常量池中
        String s2="abc";//字面量的定义方式，“abc”存储在字符串常量池中
        s2+="def";
        System.out.println(s1==s2);//false
        System.out.println(s1);//abc
        System.out.println(s2);//abcdef
    }

    @Test
    public void test3(){
        String s1="abc";//字面量的定义方式，“abc”存储在字符串常量池中
        String s2=s1.replace('a','m');
        System.out.println(s1);//abc
        System.out.println(s2);//mbc
        String s3=new String("abcd");
        String s4=s3.replace('a','m');
        System.out.println(s3);//abc
        System.out.println(s4);//mbc
    }
}
