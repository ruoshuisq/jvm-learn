package com.stephen.jvm.learn.chapter05vmstack.dynamic.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

public class InvokeMHTest {
    /**
     * 通过invokeExact方法实现
     * 最直接的调用一个方法句柄的做法是通过invokeExact方法实现的。这个方法与直接调用底层方法是完全一样的
     * invokeExact方法的参数依次是作为方法接收者的对象和调用时候的实际参数列表
     * 静态方法在调用时是不需要指定方法的接收对象的
     * @throws Throwable
     */
    public void invokeExact() throws Throwable {
        // 1.先获取String类中substring的方法句柄.
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type);
        // 2.再通过invokeExact来进行调用。
        String str = (String) mh.invokeExact("Hello World", 1, 3);
        System.out.println(str);
    }


    /**
     * 通过invoke方法实现
     * 它会尝试在调用的时候进行返回值和参数类型的转换工作。
     * 这是通过MethodHandle类的asType方法来完成的。asType方法的作用是把当前的方法句柄适配到新的MethodType上，
     * 并产生一个新的方法句柄
     * 从待转换的源类型S到目标类型T匹配成功的基本原则如下：
     * 1）可以通过Java的类型转换来完成，一般是从子类转换成父类，接口的实现类转换成接口，比如从String类转换到Object类
     * 2）可以通过基本类型的转换来完成，只能进行类型范围的扩大，比如从int类型转换到long类型。
     * 3）可以通过基本类型的自动装箱和拆箱机制来完成，比如从int类型到Integer类型。
     * 4）如果S有返回值类型，而T的返回值是void, S的返回值会被丢弃。
     * 5）如果S的返回值是void，而T的返回值是引用类型，T的返回值会是null。
     * 6）如果S的返回值是void，而T的返回值是基本类型，T的返回值会是0。
     * 满足上面规则时进行两个方法类型之间的转换是会成功的。
     * @throws Throwable
     */
    public void givenReplaceMethodHandle_whenInvoked_thenCorrectlyReplaced() throws Throwable {
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodType mt = MethodType.methodType(String.class, char.class, char.class);
        MethodHandle replaceMH = publicLookup.findVirtual(String.class, "replace", mt);
        String replacedString = (String) replaceMH.invoke("jovo", Character.valueOf('o'), 'a');
        String replacedString3 = (String) replaceMH.invoke("jovo",  'o', 'a');
        String replacedString2 = (String) replaceMH.invoke("jovo",  new Character('o'), 'a');
        String replacedString4 = (String) replaceMH.invokeExact("jovo",  'o', 'a');
//        String replacedString5 = (String) replaceMH.invokeExact("jovo",  new Character('o'), 'a'); //不能使用包装类，报错
        if("java".equals(replacedString4)){
            System.out.println(true);
        }
    }

    /**
     * 通过invokeWithArguments方法实现
     * 该方法在调用时可以指定任意多个Object类型的参数。完整的调用方式是首先根据传入的实际参数的个数.
     * 通过MethodType的genericMethodType方法得到一个返回值和参数类型都是Object的新方法类型。
     * 再把原始的方法句柄通过asType转换后得到一个新的方法句柄。
     * 最后通过新方法句柄的invokeExact方法来完成调用。
     * 这个方法相对于invokeExact和invoke的优势在于，它可以通过Java反射API被正常获取和调用，
     * 而invokeExact和invoke不可以这样。它可以作为反射API和方法句柄之间的桥梁
     * @throws Throwable
     */
    public void invokeWithArguments() throws Throwable{
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodType mt = MethodType.methodType(List.class, Object[].class);
        MethodHandle asList = publicLookup.findStatic(Arrays.class, "asList", mt);
        List<Integer> list = (List<Integer>) asList.invokeWithArguments(1,2);
//        assertThat(Arrays.asList(1,2), is(list));

    }

    public static void main(String[] args) throws Throwable {
        InvokeMHTest invokeMHTest=new InvokeMHTest();
        invokeMHTest.invokeExact();
        invokeMHTest.givenReplaceMethodHandle_whenInvoked_thenCorrectlyReplaced();
        invokeMHTest.invokeWithArguments();
    }
}
