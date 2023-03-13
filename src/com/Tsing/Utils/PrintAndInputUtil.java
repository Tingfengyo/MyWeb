package com.Tsing.Utils;

import java.util.Scanner;

/**
 * @Author: zty
 * @Date: 2022-12-21 08:58
 * @Description: 输出语句的工具类
 */
public class PrintAndInputUtil {
    //输出语句的封装
    public static void pl(Object msg){
        System.out.println(msg);
    }
    public static void p(Object msg){
        System.out.print(msg);
    }

    //控制台输入语句的封装
    public static int scInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String scStr(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
