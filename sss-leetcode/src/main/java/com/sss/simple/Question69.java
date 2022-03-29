package com.sss.simple;

/** @title:x的平方根
 *  @Author:杀神松1997
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 */
public class Question69 {
    //评论区热评第一大牛解法(二分查找)
    public static int hotSolution(int x){
        int min = 0;
        int max = x;
        while(max - min > 1){
            int mid = (max - min)/2;
            //结果在中位左边,右指针左移
            if(x/mid < mid){
                max = mid;
            }
            else {
                min = mid;
            }
        }
        return min;
    }



    public static void main(String[] args) {
        System.out.println( Math.exp(2));
    }
}
