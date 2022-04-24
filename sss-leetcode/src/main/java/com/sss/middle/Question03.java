package com.sss.middle;

import java.util.ArrayList;
import java.util.List;

/** @title:无重复字符的最长子串
 *  @Author:杀神松1997
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 */
public class Question03 {

    public static int solution(String s){
        List<Character> list = new ArrayList<Character>();
        int point = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
           if(i != 0){
               list.remove(0);
           }

           while(point < s.length() && !list.contains(s.charAt(point))){
               list.add(s.charAt(point));
               point++;
           }
           result = Math.max(result,list.size());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Question03.solution("pwwkew"));

    }
}
