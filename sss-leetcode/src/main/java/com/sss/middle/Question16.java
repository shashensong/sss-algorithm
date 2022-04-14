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
        int result = Integer.MAX_VALUE;
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
                    if(current < result){
                        result = current;
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

    //官方解
    public static List<List<Integer>> officialSolution(int[] nums){

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Question16.mySolution(new int[]{1,1,1,0},100);
    }
}
