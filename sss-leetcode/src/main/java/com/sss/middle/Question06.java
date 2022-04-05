package com.sss.middle;

/** @title:Z字形变换
 *  @Author:杀神松1997
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 */
public class Question06 {

    //官方解
    public static String officialSolution(String s, int numRows){
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();

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
        System.out.println(Question06.officialSolution("PAYPALISHIRING",3));

    }
}
