package com.stephen.jvm.learn.chapter05vmstack.dispatch;

/**
 * @BelongsProject: jvm-learn
 * @BelongsPackage: com.stephen.jvm.learn.chapter05vmstack.dispatch
 * @Author: zhaojiang
 * @CreateTime: 2022-09-02  11:22
 * @Description: 字段不参与多态
 * @Version: 1.0
 */
public class FieldHasNoPolymorphic {

    static class Father extends Object{
        public int money = 1;
        public Father() {
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }
    static class Son extends Father {
        public int money = 3;
        public Son() {
            money = 4;
            showMeTheMoney();
        }
        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son, i have $" + money);
        }
    }
    public static void main(String[] args) {
        //该方法执行大概步骤
        //1、new Son():创建Son类型的对象，分配内存空间并初始化空间：在堆中为对象分配内存空间，设置对象属性为默认值；约定堆中该Son对象为*A，A为该Son对象引用
        //2、new Son():开始执行*A的init方法（即构造方法），参数为A
        //3、new Son():执行*A的init过程：从本地变量表中加载A至栈顶
        //4、new Son():执行*A的init过程：开始执行父类Father的init方法（即构造方法），参数为A（注意未创建父类对象）
        //5、new Son():执行*A的init过程：执行Father的init过程：从本地变量表中加载A至栈顶，初始化Father的属性money为1
        //6、new Son():执行*A的init过程：执行Father的init过程：从本地变量表中加载A至栈顶，执行showMeTheMoney()方法，该方法为虚方法，实际执行*A的showMeTheMoney()方法
        //7、new Son():执行*A的init过程：执行Father的init结束
        //8、new Son():执行*A的init过程：初始化*A的属性money为3，执行showMeTheMoney()方法，该方法为虚方法，实际执行*A的showMeTheMoney()方法
        //9、new Son():执行*A的init结束，new Son()结束
        //10、本地变量表存储gay，类型Father
        //11、打印Father的属性money
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money);
    }
}
