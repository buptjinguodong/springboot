package com.imooc.demo.utils;

public class ComFun {
    public static void log(String info){
        System.out.println(info);
    }

    public static void logDepth(String info, int depth) {
        for (int i=0; i<depth; i++) {
            System.out.print(" - ");
        }
        System.out.println(info);
    }
}
