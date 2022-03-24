package com.sss.simple;

/** @title:最大子数组和
 *  @Author:杀神松1997
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * 示例：输入 nums=[-2,1,-3,4,-1,2,1,-5,4] 输出：6  连续子数组[4,-1,2,1]的和最大
 */
public class Question53 {

    //杀神松解
    public static int mySolution(int nums[]){
        int sum = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0){
                sum += nums[i];
            }
            else {
                sum = nums[i];
            }
            result = Math.max(result,sum);
        }
        return result;
    }

    

    public static void main(String[] args) {
        System.out.println(Question53.mySolution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
