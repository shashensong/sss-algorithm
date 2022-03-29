package com.sss.simple;

import java.util.Arrays;

/** @title:二进制求和
 *  @Author:杀神松1997
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 */
public class Question67 {

    public static String mySolution(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    public static void main(String[] args) {
        System.out.println(Question67.mySolution("101","11"));
    }
}
