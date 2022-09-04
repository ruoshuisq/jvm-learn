package com.stephen.jvm.learn.chapter09metaspace.d1;

/**
 * dup指令的作用：dup指令可以复制操作数栈栈顶的一个字，再将这个字压入栈。也就是对栈顶的内容做了个备份，此时操作数栈上有连续相同的两个对象地址;
 * 新建对象的new 指令后，为什么一定要dup操作呢:
 * 因为java代码的new操作编译为虚拟机指令后，
 * 虚拟机指令new在堆上分配了内存并在栈顶压入了指向这段内存的地址供任何下面的操作来调用，
 * 但是在这个操作数被程序员能访问的操作之前，虚拟机自己肯定要调用对象的 <init> 方法，
 * 也就是如果程序员做一个 Type a = new Type(); 其实要连续两次对栈顶的操作数进行操作。其中一次是虚拟机内部自动调用的，另一次才是程序员的访问，例如给变量赋值，抛出异常等;
 * 有人说那可以直接从栈顶先store到内存中，需要操作的时候再load到栈顶啊，注意在没有<init>操作之前，这个对象对于程序员是不可见的，否则就会访问到残废的对象，所以只能是先<init>然后才能store到内存中。这两步操作的操作数必须都直接是原来已经存在栈中的，所以只能是dup
 *
 *
 */
public class DupTest {
    //当常数2被压入栈顶后，它要连续两次store到变量x和y，所以这里编译后肯定有一个dup操作
    //如果不做dup操作，那么istore_1将20存到内存中的x后，再istore_2要么没有操作数，要么是一个其它的操作数。
    //当然这在编译时对连续操作已经做dup操作了，所以不会真的出现这个情况。
    public static void main(String[] args) {
        int x;
        int y = x = 2;
    }

//    1) 其中new指令在java堆上为 DupTest 对象分配内存空间，并将地址压入操作数栈顶；
//    2) 然后dup指令为复制操作数栈顶值，并将其压入栈顶，也就是说此时操作数栈上有连续相同的两个对象地址；
//    3) invokespecial指令调用实例初始化方法<init>:()V，注意这个方法是一个实例方法，所以需要从操作数栈顶弹出一个DupTest 对象的引用，也就是说这一步会弹出一个之前入栈的对象地址；
//    4) astore_1 指令从操作数栈顶取出 DupTest 对象的引用并存到局部变量表；
//    5) 最后由return指令结束方法。
//    从上面的五个步骤中可以看出，需要从栈顶弹出两个实例对象的引用
    public void test() {
        DupTest dt = new DupTest();
    }
//1) 其中new指令在java堆上为Exception对象分配内存空间，并将地址压入操作数栈顶；
//2) 然后dup指令为复制操作数栈顶值，并将其压入栈顶，也就是说此时操作数栈上有连续相同的两个对象地址；
//3) invokespecial指令调用实例初始化方法<init>:()V，注意这个方法是一个实例方法，所以需要从操作数栈顶弹出一个this引用，也就是说这一步会弹出一个之前入栈的对象地址；
//4) athrow指令从操作数栈顶取出一个引用类型的值，并抛出；
    void cantBeZero(int i) throws Exception{
        throw new Exception();
    }

    //可以看到，在仅仅调用了 new DupTest() 的情况下，java编译器仍然生成了一条 dup 指令，紧接着虚拟机调用了 <init> 方法，然后立即一条 pop 指令弹出了那个被复制的操作数
    public void test2() {
        new DupTest();
    }

    public DupTest test3() {
       return new DupTest();
    }

    public void test4() {
        DupTest dupTest=test3();
        dupTest.test();
    }

    public void test5() {
        MethodAreaDemo o=new MethodAreaDemo();
        MethodAreaDemo.test1(o);
    }




}
