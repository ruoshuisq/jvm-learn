1、说一下JVM内存模型吧，有哪些区？分别干什么的？

2、Java8的内存分代改进

3、JVM内存分哪几个区，每个区的作用是什么？

4、JVM内存分布/内存结构？栈和堆的区别？堆的结构？为什么两个survivor区

5、Eden和Survivor的比例分配

6、JVM内存分区，为什么要有新生代和老年代

7、Java的内存分区

8、讲讲JVM运行时数据区

9、什么时候对象会进入老年代

10、JVM的永久代中会发生垃圾回收吗？

JVM规范没有强制规定永久代即方法区必须回收，但是对方法区的回收有时是非常必要的，Java11时期的ZGC没有对方法区进行回收。

11、对象在JVM中是怎么存储的？

12、对象头信息里面有哪些东西？

13、new String("ab")会创建几个对象？

14、new String("a")+new String("b")会创建几个对象？

15、以下代码运行结果

```java
public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
```

16、jvm什么是垃圾（Garbage）

![image-20220912221604656](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220912221604656.png)

![image-20220912221709434](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220912221709434.png)

17、哪些内存需要回收

18、什么时候回收

19、如何回收

![image-20220912221025236](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220912221025236.png)

![image-20220912221141810](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220912221141810.png)

20、什么是内存泄漏（Memory Leak）和内存溢出（OOM）

Memeory Leak

1、单例模式，单例对象引用外部对象，外部对象不能被回收，则可能会导致内存泄漏

2、一些提供close的资源未关闭导致内存泄漏

![image-20220917215054356](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220917215054356.png)



21、对象的三种可能状态？
    1）、可触及的
    2）、可复活的
    3）、不可触及的

![image-20220914233334230](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220914233334230.png)

22、并发（Concurrent）和并行（Parallel）

23、安全点（Safe Point）和安全区域（Safe Region）

抢先试中断

主动式中断

24、强引用（Strong Reference）、软引用（Soft Reference）、弱引用（Weak Reference）、虚引用（Phantom Reference）

25、你在开发中使用过WeakHashMap吗

26、![image-20220919212752588](C:\Users\aystl\AppData\Roaming\Typora\typora-user-images\image-20220919212752588.png)
