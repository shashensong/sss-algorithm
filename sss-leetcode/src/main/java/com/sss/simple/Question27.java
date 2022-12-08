package com.sss.simple;

/** @title:移除元素
 *  @Author:杀神松1997
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Question27 {

    //杀神松解
    public static int mySolution(int nums[],int val){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
       for (int j = 0; j < nums.length; j++) {
           if(nums[j] != val){
               nums[i] = nums[j];
               i++;
           }
       }
       return i;
    }

    //官方解
    public static int officialSolution(int nums[],int val){
     int n = nums.length;
    int left = 0;
        for (int right = 0; right < n; right++) {
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
     return left;
    }

    public static void main(String[] args) {
        System.out.println(Question27.mySolution(new int[]{1,5,5,2,0},2));
    }
}
