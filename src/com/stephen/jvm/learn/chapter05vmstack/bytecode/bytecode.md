Java 字节码由操作码和操作数组成

    操作码（Opcode）：一个字节长度（0-255，意味着指令集的操作码总数不可能超过 256 条），代表着某种特定的操作含义。
    操作数（Operands）：零个或者多个，紧跟在操作码之后，代表此操作需要的参数。
    由于 Java 虚拟机是基于栈而不是寄存器的结构，所以大多数指令都只有一个操作码。比如 aload_0（将局部变量表中下标为 0 的数据压入操作数栈中）就只有操作码没有操作数，而 invokespecial #1（调用成员方法或者构造方法，并传递常量池中下标为 1 的常量）就是由操作码和操作数组成的。
# 1、加载与存储指令

加载（load）和存储（store）相关的指令是使用最频繁的指令，用于将数据从栈帧的局部变量表和操作数栈之间来回传递。
## 1.1、将局部变量表中的变量压入操作数栈中
```
 1)xload_<n>（x 为 i、l、f、d、a，n 默认为 0 到 3），表示将第 n 个局部变量压入操作数栈中。
 2)xload（x 为 i、l、f、d、a），通过指定参数的形式，将局部变量压入操作数栈中，当使用这个指令时，表示局部变量的数量可能超过了4个。  
    x 为操作码助记符，表明是哪一种数据类型。见下表所示。
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/631ddab1090c46dfa1c5876a2dbdbc24.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5Lmd5biI5YWE,size_20,color_FFFFFF,t_70,g_se,x_16)

实例：

```java
    public void load(int age, String name, long birthday, boolean sex) {
        System.out.println(age + name + birthday + sex);
    }
```

通过 jclasslib 看一下 `load()` 方法（4 个参数）的字节码指令

![image-20220829164157678](C:\Users\zj\AppData\Roaming\Typora\typora-user-images\image-20220829164157678.png)

```
iload_1：将局部变量表中下标为 1 的 int 变量压入操作数栈中。
aload_2：将局部变量表中下标为 2 的引用数据类型变量（此时为 String）压入操作数栈中。
lload_3：将局部变量表中下标为 3 的 long 型变量压入操作数栈中。
iload 5：将局部变量表中下标为 5 的 int 变量（实际为 boolean）压入操作数栈中。
```

## 1.2、将常量池中的常量压入操作数栈中

根据数据类型和入栈内容的不同，此类又可以细分为 `const 系列、push 系列和 Idc 指令`。

const 系列，用于特殊的常量入栈，要入栈的常量隐含在指令本身。

![在这里插入图片描述](https://img-blog.csdnimg.cn/905966c70c5c43e9a8b345980a2e0f8d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5Lmd5biI5YWE,size_20,color_FFFFFF,t_70,g_se,x_16)

```
push 系列，主要包括 bipush 和 sipush，前者接收 8 位整数作为参数，后者接收 16 位整数。

Idc 指令，当 const 和 push 不能满足的时候，万能的 Idc 指令就上场了，它接收一个 8 位的参数，指向常量池中的索引。
```

```
Idc_w：接收两个 8 位数，索引范围更大。
如果参数是 long 或者 double，使用 Idc2_w 指令。
```

举例

```java
public void pushConstLdc() {
    // 范围 [-1,5]
    int iconst = -1;
    // 范围 [-128,127]
    int bipush = 127;
    // 范围 [-32768,32767]
    int sipush= 32767;
    // 其他 int
    int ldc = 32768;
    String aconst = null;
    String IdcString = "沉默王二";
}
```

通过 jclasslib 看一下 `pushConstLdc()` 方法的字节码指令。

![image-20220829173450951](C:\Users\zj\AppData\Roaming\Typora\typora-user-images\image-20220829173450951.png)

```
iconst_m1：将 -1 入栈。范围 [-1,5]。
bipush 127：将 127 入栈。范围 [-128,127]。
sipush 32767：将 32767 入栈。范围 [-32768,32767]。
ldc #6 <32768>：将常量池中下标为 6 的常量 32768 入栈。
aconst_null：将 null 入栈。
ldc #7 <沉默王二>：将常量池中下标为 7 的常量“沉默王二”入栈。
```

## 1.3将栈顶的数据出栈并装入局部变量表中

主要是用来给局部变量赋值，这类指令主要以 store 的形式存在。

```
xstore_<n>（x 为 i、l、f、d、a，n 默认为 0 到 3）
xstore（x 为 i、l、f、d、a）
```

`xstore_<n> 和 xstore n` 的区别在于，前者相当于只有操作码，占用 1 个字节；后者相当于由操作码和操作数组成，操作码占 1 个字节，操作数占 2 个字节，一共占 3 个字节。

由于局部变量表中前几个位置总是非常常用，虽然 `xstore_<n> 和 xload_<n>` 增加了指令数量，但字节码的体积变小了！

举例

```java
public void store(int age, String name) {
    int temp = age + 2;
    String str = name;
}
```

通过 jclasslib 看一下 `store()` 方法的字节码指令。

![image-20220829173542619](C:\Users\zj\AppData\Roaming\Typora\typora-user-images\image-20220829173542619.png)

```
istore_3：从操作数中弹出一个整数，并把它赋值给局部变量表中索引为 3 的变量。
astore 4：从操作数中弹出一个引用数据类型，并把它赋值给局部变量表中索引为 4 的变量。
```



[(9条消息) 【java】JVM字节码指令详解_九师兄的博客-CSDN博客_jvm字节码指令](https://blog.csdn.net/qq_21383435/article/details/124412828)

document.designMode = 'on'
