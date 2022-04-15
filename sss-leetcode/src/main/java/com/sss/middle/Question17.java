package com.sss.middle;

import java.util.*;

/** @title:电话号码的字母组合
 *  @Author:杀神松1997
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Question17 {

    //官方解
    public static List<String> officialSolution(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(result,phoneMap,digits,0,new StringBuffer());
    return result;
    }
    public static void backTrack(List<String> result,Map<Character, String> phoneMap,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            result.add(combination.toString());
        }
        else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backTrack(result,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {


    }
}
