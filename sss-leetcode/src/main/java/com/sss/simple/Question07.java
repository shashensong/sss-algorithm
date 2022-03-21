package com.sss.simple;

/** @title:回文数
 *  @Author:杀神松1997
 * 给你一个整数x，如果x是一个回文整数，返回true，否则，返回false
 * 例如，121是回文，而123不是
 */
public class Question07 {
    public static boolean solution(int x){
        //边界条件
        if(x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber){
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
       return x == reverseNumber || x == reverseNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(Question07.solution(121));
    }
}
