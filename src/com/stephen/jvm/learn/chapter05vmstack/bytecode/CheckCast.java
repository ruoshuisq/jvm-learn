package com.stephen.jvm.learn.chapter05vmstack.bytecode;

public class CheckCast {

    //类型检查指令
    public String checkcast(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return null;
        }
    }

}
