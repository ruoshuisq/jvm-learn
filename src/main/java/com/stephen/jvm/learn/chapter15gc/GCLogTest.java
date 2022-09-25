package com.stephen.jvm.learn.chapter15gc;

import java.util.ArrayList;

/**
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -Xloggc:./logs/gc8.log -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
 * jdk11+ -Xms60m -Xmx60m -XX:SurvivorRatio=8 -Xlog:gc*=info:./logs/gc17zgc.log:time
 * jdk11+ -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Xlog:gc*=info:./logs/gc17zgc.log:time
 * @author shkstart  shkstart@126.com
 * @create 2020  18:12
 */
public class GCLogTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 100];//100KB
            list.add(arr);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
