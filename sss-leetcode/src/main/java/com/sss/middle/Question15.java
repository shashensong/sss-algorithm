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
       List<List<Integer>> list = Question15.mySolution(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
    }
}
