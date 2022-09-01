package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class Switch {

    public void switchTest(int select) {
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 5:
                num = 20;
                // break;
            case 30:
                num = 30;
                break;
            default:
                num = 40;
        }
    }

}
