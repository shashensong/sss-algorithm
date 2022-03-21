package com.sss;

/** @title:买卖股票的最佳时机
 *  @Author:杀神松1997
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这支股票，并选择在未来的某一个不同的日子卖出该股票，设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。如果你不能获取任何利润，返回0
 */
public class Question121 {
    public static int solution(int arr[]){
        int maxProfit = 0;
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < current){
                current = arr[i];
            }
            else {
                maxProfit = Math.max(maxProfit,arr[i] - current);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(Question121.solution(new int[]{7,1,5,3,6,4}));
    }
}
