package com.sss.middle;

import java.util.*;

/** @title:最接近的三数之和
 *  @Author:杀神松1997
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class Question16 {
    //杀神松解
    public static int mySolution(int[] nums, int target){
        if(nums.length < 3){
            return 0;
        }
        //排序使用双指针便于管理
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int ans = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length - 1; first++) {
           //该元素已经遍历过了 跳过避免重复
            if(first != 0 && nums[first] == nums[first-1]){
                continue;
            }
            for (int second = first + 1; second < nums.length - 1; second++) {
                int third = nums.length - 1;

                //该元素已经遍历过了 跳过避免重复
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third){
                    int sum = nums[first] + nums[second] + nums[third];
                    int current = Math.abs(target-(nums[first] + nums[second] + nums[third]));
                    if(current == 0){
                        return sum;
                    }
                    if(current < distance){
                        distance = current;
                        ans = sum;
                    }
                    if(sum <= target){
                        break;
                    }
                    third--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question16.mySolution(new int[]{-1,2,1,-4},1);
    }
}
