package com.sss.middle;

/** @title:最长回文子串
 *  @Author:杀神松1997
 * 给你一个字符串 s，找到 s 中最长的回文子串。
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
            i = findStr(str,i,result);
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
       if (high - low > range[1] - range[0]){
           range[0] = low;
           range[1] = high;
       }
       return ans;
    }


    public static void main(String[] args) {
        System.out.println(Question05.hotSolution("baab"));

    }
}
