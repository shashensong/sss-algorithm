package com.sss.simple;

import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

/** @title:删除有序数组中的重复项
 *  @Author:杀神松1997
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Question26 {

    //杀神松解
    public static int mySolution(int nums[]){
        if(nums.length == 0){
            return 0;
        }
        int i = 1;
       for (int j = 1; j < nums.length; j++) {
           if(nums[j] != nums[j-1]){
               nums[i] = nums[j];
               i++;
           }
       }
       return i;
    }

    //官方解
    public static int officialSolution(int nums[]){
     int n = nums.length;
     if(n == 0){
         return 0;
     }
     int fast = 1,slow = 1;
     while (fast < n){
         if(nums[fast] != nums[fast-1]){
             nums[slow] = nums[fast];
             ++slow;
         }
         ++fast;
     }
     return slow;
    }

    public static void main(String[] args) {
        System.out.println(Question26.mySolution(new int[]{1,2,3,3,4,5,5}));
    }
}
