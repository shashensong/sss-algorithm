package com.sss.middle;

import java.util.*;

/** @title:三数之和
 *  @Author:杀神松1997
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class Question15 {
    //杀神松解
    public static List<List<Integer>> mySolution(int[] nums){
        if(nums.length == 0){
            return new ArrayList<>();
        }
        //排序使用双指针便于管理
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            //Hash表求解减少时间复杂度
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
           int low = i;
           //该元素已经遍历过了 跳过避免重复
            if(low != 0 && nums[low] == nums[low-1]){
                continue;
            }
           int high = i+1;
           int current =-nums[low];
            List<Integer> currentResult = new ArrayList<>();
            while (high < nums.length){
                if(map.containsKey(current-nums[high])){
                    currentResult.add(-current);
                    currentResult.add(current-nums[high]);
                    currentResult.add(nums[high]);
                    //该元素已经遍历过了 跳过避免重复
                    while(high < nums.length -1 && nums[high] == nums[high+1]){
                        high++;
                    }
                    //到最后一位依旧是遍历过的元素，直接break
                    if(high >= nums.length){
                        break;
                    }
                }
                else {
                    map.put(nums[high],high);
                }
                if(currentResult.size() != 0){
                    result.add(currentResult);
                    //清空数组
                    currentResult = new ArrayList<>();
                }
                high++;
            }

        }
        return result;
    }

    //官方解
    public static int officialSolution(int[] height){
     return 0;
    }


    public static void main(String[] args) {
       List<List<Integer>> list = Question15.mySolution(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
    }
}
