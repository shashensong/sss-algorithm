package com.sss.simple;

/** @title:移除元素
 *  @Author:杀神松1997
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 输入：nums[1,3,5,6],target=5 输出：2
 */
public class Question35 {

    //杀神松解
    public static int mySolution(int nums[],int target){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == target){
                return j;
            }
            if(nums[j] < target){
                i++;
            }
        }
        return i;
    }

    //官方解(二分查找)
    public static int officialSolution(int nums[],int target){
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            if(target <= nums[mid]){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Question35.officialSolution(new int[]{1,3,5},2));
    }
}
