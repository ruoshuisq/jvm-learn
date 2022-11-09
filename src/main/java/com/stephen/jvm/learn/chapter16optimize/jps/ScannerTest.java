package com.stephen.jvm.learn.chapter16optimize.jps;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 14:57
 * -XX:-UsePerfData
 *
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.next();
    }
}
