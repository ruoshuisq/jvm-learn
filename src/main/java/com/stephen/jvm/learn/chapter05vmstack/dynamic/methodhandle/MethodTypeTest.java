package com.stephen.jvm.learn.chapter05vmstack.dynamic.methodhandle;

import java.lang.invoke.MethodType;

public class MethodTypeTest {
    /**
     * 显式地指定返回值和参数的类型
     */
    public void generateMethodTypes(){
        //String.length()
        MethodType mt1=MethodType.methodType(int.class);
        //String.concat(String str)
        MethodType mt2=MethodType.methodType(String.class, String.class);
        //String.getChars(int srcBegin, int srcEnd, char[]dst, int dstBegin)
        MethodType mt3=MethodType.methodType(void.class, int.class, int.class, char[].class, int.class);
        //String.startsWith(String prefix)
        MethodType mt4=MethodType.methodType(boolean.class, mt2);
    }

    public void generateGenericMethodTypes(){
        //第一种形式只需要指明方法类型中包含的Object类型的参数个数即可
        MethodType mt1=MethodType.genericMethodType(3);
        //第二种形式可以提供一个额外的参数来说明是否在参数列表的后面添加一个Object[]类型的参数
        MethodType mt2=MethodType.genericMethodType(2,true);
    }

    /**
     * 指定方法类型在字节代码中的表示形式作为创建MethodType时的参数
     * 注意：在使用fromMethodDescriptorString方法的时候，
     * 需要指定一个类加载器。该类加载器用来加载方法类型表达式中出现的Java类。如果不指定，默认使用系统类加载器
     */
    public void generateMethodTypesFromDescriptor(){
        ClassLoader cl=this.getClass().getClassLoader();
        //所表示的方法类型是返回值和参数类型都是java.lang.String，相当于使用MethodType.methodType(String.class, String.class)
        String descriptor="(Ljava/lang/String;)Ljava/lang/String;";
        MethodType mt1=MethodType.fromMethodDescriptorString(descriptor, cl);
    }

    /**
     * 围绕返回值和参数类型的精确修改
     * 所有这些修改方法都返回另外一个新的MethodType对象
     */
    public void changeMethodType(){
        //(int, int)String
        MethodType mt=MethodType.methodType(String.class, int.class, int.class);
        //(int, int, float)String
        mt=mt.appendParameterTypes(float.class);
        //(int, double, long, int, float)String
        mt=mt.insertParameterTypes(1,double.class, long.class);
        //(int, double, int, float)String
        mt=mt.dropParameterTypes(2,3);
        //(int, double, String, float)String
        mt=mt.changeParameterType(2,String.class);
        //(int, double, String, float)void
        mt=mt.changeReturnType(void.class);
    }

    /**
     * 一次性对返回值和所有参数的类型进行修改
     * 其中wrap和unwrap用来在基本类型及其包装类型之间进行转换，
     * generic方法把所有返回值和参数类型都变成Object类型，
     * 而erase只把引用类型变成Object，并不处理基本类型
     */
    public void wrapAndGeneric(){
        //(int, double)Integer
        MethodType mt=MethodType.methodType(Integer.class, int.class, double.class);
        //(Integer, Double)Integer
        MethodType wrapped=mt.wrap();
        //(int, double)int
        MethodType unwrapped=mt.unwrap();
        //(Object, Object)Object
        MethodType generic=mt.generic();
        //(int, double)Object
        MethodType erased=mt.erase();
    }

    public static void main(String[] args) {
        MethodTypeTest methodTypeTest = new MethodTypeTest();
        methodTypeTest.generateMethodTypes();
        methodTypeTest.generateGenericMethodTypes();
    }
}
