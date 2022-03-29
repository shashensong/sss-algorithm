package com.sss.simple;

import java.util.Arrays;

/** @title:加一
 *  @Author:杀神松1997
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class Question66 {

    //杀神松解
    public static int[] mySolution(int[] digits){
        boolean carry = false;
        if(digits[digits.length-1] == 9){
            digits[digits.length-1] = 0;
            carry = true;
            for (int i = digits.length - 2; i >= 0 ; i--) {
                if(digits[i] == 9 && carry){
                    digits[i] = 0;
                    carry = true;
                }
                else if(carry){
                    digits[i] += 1;
                    carry = false;
                }
            }
        }
        else {
            digits[digits.length-1] = digits[digits.length-1] + 1;
        }
        if(carry){
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    //杀神松解升级改进版
    public static int[] mySolutionPlus(int[] digits){
        boolean carry = true;
        int count = digits.length - 1;
        while(carry && count >= 0){
           if(digits[count] != 9){
               digits[count] += 1;
               carry = false;
           }
           else {
               digits[count] = 0;
           }
           count--;
        }
        if(carry){
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    //评论区热评第一大牛解法
    public int[] hotSolution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Question66.mySolutionPlus(new int[]{9,9,9,9})));
    }
}
