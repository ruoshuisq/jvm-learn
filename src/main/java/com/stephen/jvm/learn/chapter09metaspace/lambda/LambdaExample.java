package com.stephen.jvm.learn.chapter09metaspace.lambda;

import java.lang.invoke.*;
import java.lang.reflect.Method;

/**
 * @BelongsProject: jvm-learn
 * @BelongsPackage: com.stephen.jvm.learn.chapter09metaspace.lambda
 * @Author: stephen
 * @CreateTime: 2022-09-05  09:42
 * @Description: lambda test
 * @Version: 1.0
 */
public class LambdaExample {
    private static final String HELLO = "Hello";

    public static void main(String[] args) throws Throwable {
        Runnable r = () -> System.out.println(HELLO);
        Thread t = new Thread(r);
        t.start();
        t.join();
        Operator m = (int a,int b,int c) -> {
            return a+b-c;
        };
        Operator m2 = (int a,int b,int c) -> {
            return a+b+c;
        };
        int n = m.toOperate(1,2,3);
        int n2=m2.toOperate(1,2,3);
        System.out.println(n);
        System.out.println(n2);
        lambdaSimulation();
    }

    public static void lambdaSimulation() throws Throwable {
        String className="com.stephen.jvm.learn.chapter09metaspace.lambda.Operation";
        String methodName="operate";
        //通过全类名，获取类的实例
        Class clazz=Class.forName(className);
        //获取到类的对象，要求该类必须有无参构造
        Operation o = (Operation)clazz.newInstance();
        //获取方法对象
        Method method= clazz.getDeclaredMethod(methodName,int.class,int.class,int.class);
        MethodHandles.Lookup lookup=MethodHandles.lookup();
        //指定方法不以反射运行
        MethodHandle mh=lookup.unreflect(method);
        //获取方法的类型
        MethodType type=mh.type();
        //将方法的实例对象类型加到方法类型工厂里
        MethodType factoryType=MethodType.methodType(Operator.class,type.parameterType(0));
        //移除方法里的实例对象类型
        type=type.dropParameterTypes(0,1);
        //获取代理对象，注意，第二个参数的字符串必须为函数式接口里的方法名
        CallSite toOperate = LambdaMetafactory.metafactory(lookup, "toOperate", factoryType, type, mh, type);
        MethodHandle target = toOperate.getTarget();
        Operator operator=(Operator)  target.invoke(o);
//        Operator operator=(Operator) LambdaMetafactory.metafactory(lookup,"toOperate",factoryType,type,mh,type).getTarget().invokeExact(o);
        int operate = operator.toOperate(1, 2, 5);
        System.out.println(operate);
    }
}

@FunctionalInterface
/**
 * 自定义的函数式接口，用于lambda调用
 */
interface Operator {
    /**
     * 入参应和被lambda调用的方法一致，在本例中是Operation中的operate方法
     * @param a
     * @param b
     * @param c
     * @return 返回值应和被lambda调用的方法一致，在本例中是Operation中的operate方法
     */
    int toOperate(int a,int b,int c);
}

/**
 * 被lambda调用的类和方法
 */
class Operation {
    public int operate(int a,int b,int c){
        return a+b-c;
    }
}
