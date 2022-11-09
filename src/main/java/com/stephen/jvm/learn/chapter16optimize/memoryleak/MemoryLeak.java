package com.stephen.jvm.learn.chapter16optimize.memoryleak;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟内存泄漏
 *
 * @author shkstart
 * @create 21:20
 */
public class MemoryLeak {
    static List list = new ArrayList();

    public void oomTests() {
        Object obj = new Object();
        list.add(obj);
    }

}