package com.sss.middle;

/** @title:整数反转
 *  @Author:杀神松1997
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 */
public class Question07 {

    //杀神松解
    public static int mySolution(int x){
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == (int)result ? (int)result : 0;
    }

    //官方解
    public int officialSolution(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


    public static void main(String[] args) {
        System.out.println(Question07.mySolution(321));
    }
}
