package com.stephen.jvm.learn.chapter05vmstack.dynamic.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class ArgsBindTo {

    /**
     * 参数绑定
     * 通过MethodHandle的bindTo方法可以预先绑定底层方法的调用接收者
     * 在实际调用的时候，只需要传入实际参数即可，不需要再指定方法的接收者
     * @throws Throwable
     */
    public void bindTo()throws Throwable{
        MethodHandles.Lookup lookup=MethodHandles.lookup();
        MethodHandle mh=lookup.findVirtual(String.class,"length", MethodType.methodType(int.class));
        //第一种没有进行绑定，调用时需要传入length方法的接收者
        int len=(int)mh.invoke("Hello");//值为5
        //第二种方法预先绑定了一个String类的对象，因此调用时不需要再指定
        mh=mh.bindTo("Hello World");
        len=(int)mh.invoke();//值为11
    }

    /**
     * 多次参数绑定的示例
     * @throws Throwable
     */
    public void multipleBindTo()throws Throwable{
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(String.class,"indexOf",MethodType.methodType(
                int.class, String.class, int.class));
        mh = mh.bindTo("Hello").bindTo("l");
        int index = "Hello".indexOf('l',2);
//        assertEquals(index, mh.invoke(2)); // true
        if(mh.invoke(2).equals(index)){
            System.out.println(true);
        }
    }

    /**
     * 基本类型参数的绑定方式
     * @throws Throwable
     */
    public void multipleBindTo2()throws Throwable{
        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodHandle mh = lookup.findVirtual(String.class,"indexOf",MethodType.methodType(
//        int.class, String.class, int.class));
//        mh = mh.bindTo("Hello").bindTo("l");
//        int index = "Hello".indexOf('l',2);
//        assertEquals(index, mh.invoke(2));
        MethodHandle mh=lookup.findVirtual(String.class,"substring",MethodType.methodType(String.class, int.class,
                int.class));
        mh=mh.asType(mh.type().wrap());
        mh=mh.bindTo("Hello World").bindTo(3);
        String  str = "Hello World".substring(3,5);
        System.out.println(mh.invoke(5));//值为“lo”
//        assertEquals(str, mh.invoke(5));
        if(mh.invoke(5).equals(str)){
            System.out.println(true);
        }
    }


    public static void main(String[] args) throws Throwable {
        ArgsBindTo argsBindTo=new ArgsBindTo();
        argsBindTo.bindTo();
        argsBindTo.multipleBindTo();
        argsBindTo.multipleBindTo2();
    }


}
