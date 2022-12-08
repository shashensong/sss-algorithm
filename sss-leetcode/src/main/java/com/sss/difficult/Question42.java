package com.sss.difficult;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/** @title:接雨水
 *  @Author:杀神松1997
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class Question42 {
    //杀神松解(超时惹)
    public static int solution(int[] height) {
        int result = 0;
        if(height.length <= 1){
            return result;
        }
        for (int i = 1; i < height.length;) {
            int obstacle = 0;
            int high = i + 1;
            while (high < height.length){
                if(height[high] >= height[i]){
                    break;
                }
                else {
                    obstacle += height[high];
                }
                high++;
            }
            if(high >= height.length){
                continue;
            }
            int weight = high - i - 1;
            int area = weight * height[i] - obstacle;
            result += area;
            i = high;
        }
        return result;
    }

    //杀神松解2(动态规划)
    public static int solutionTwo(int[] height) {
        int result = 0;
        //元素左边最大长度记录
        int[] leftMax = new int[height.length];
        //元素右边最大长度记录
        int[] rightMax = new int[height.length];
        //初始化数组
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        //遍历获取结果
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return result;
    }

    //杀神松解3(单调栈)
    public static int solutionThree(int[] height) {
        int result = 0;
        if(height.length <= 2){
            return result;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]){
                int top = deque.pop();
                if(deque.isEmpty()){
                    break;
                }
                int left = deque.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i],height[left])-height[top];
                result += curWidth * curHeight;
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Question42.solution(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
