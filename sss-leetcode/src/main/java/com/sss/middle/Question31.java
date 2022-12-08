package com.sss.middle;

import com.sss.repository.ListNode;

import java.util.*;
import java.util.stream.Collectors;

/** @title:下一个排列
 *  @Author:杀神松1997
 * 整数数组的一个 排列就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 *
 */

public class Question31 {

    //杀神松解
    public static void mySolution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        list.add(nums[nums.length-1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            int finalI = i;
            if(nums[i+1] > nums[i]){
                //获得之前元素中所有大于当前元素的元素
                List<Integer> gList= list.stream().filter(x->x > nums[finalI]).collect(Collectors.toList());
                if(gList.size() != 0){
                    //获取比当前元素大的元素中最小的元素的下标
                    int p = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).lastIndexOf(Collections.min(gList));
                    //交换
                    swap(nums,i,p);
                    Arrays.sort(nums,i+1,nums.length);
                    //如果交换过说明当前序列不是最大序列。如果没交换过，则需要把最大序列倒转
                    flag = true;
                    break;
                }
            }
            else {
                list.add(nums[i]);
            }
        }
        if (!flag){
            reverse(nums,0);
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Question31.mySolution(new int[]{1,3,2});
    }
}
