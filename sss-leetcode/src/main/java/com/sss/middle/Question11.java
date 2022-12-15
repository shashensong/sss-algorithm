package com.sss.middle;

/** @title:盛最多水的容器
 *  @Author:杀神松1997
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Question11 {

    //杀神松解(暴力解法不推荐)
    public static int mySolution(int[] height){
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int w = 0;
            int h = 0;
            int area = 0;
            for (int j = i + 1; j < height.length; j++) {
                w = Math.abs(j - i);
                    h = Math.min(height[i],height[j]);
                    if(w * h > area){
                        area = w * h;
                    }
            }
            result = Math.max(result,area);
        }
        return result;
    }

    //官方解
    public static int officialSolution(int[] height){
        int low = 0;
        int high = height.length-1;
        int result = 0;
        while (low != high){
            int area = (high - low) * Math.min(height[low], height[high]);
            if(height[low] < height[high]){
                low++;
            }
            else {
                high--;
            }
            result = Math.max(result,area);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
