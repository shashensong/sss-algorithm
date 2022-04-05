package com.sss.middle;

import java.util.ArrayList;
import java.util.List;

/** @title:最长回文子串
 *  @Author:杀神松1997
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class Question05 {

    //热评大牛解
    public static String hotSolution(String s){
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] str = s.toCharArray();
        //结果
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) {
            findStr(str,i,result);
        }
        return s.substring(result[0],result[1]+1);
    }

    public static int findStr(char[]str,int low,int[]range){
       int high = low;
       while(high < str.length - 1 && str[low] == str[high+1]){
           high++;
       }
       int ans = high;
       while (low > 0 && high < str.length - 1 && str[low-1] == str[high+1]){
           low--;
           high++;
       }
       while (high - low > range[1] - range[0]){
           range[0] = low;
           range[1] = high;
       }
       return ans;
    }


    public static void main(String[] args) {
        System.out.println(Question05.hotSolution("baab"));

    }
}
