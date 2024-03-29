package com.sss.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** @title:两数之和
 *  @Author:杀神松1997
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Question01 {
    public static int[] solution(int[] arr,int target){
        //Hash表求解减少时间复杂度
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target-arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
            else {
                map.put(arr[i],i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,7,11,15},9)));
    }
}
