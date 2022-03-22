package com.sss.simple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/** @title:有效的括号
 *  @Author:杀神松1997
 * 给定一个只包括'(',')','{','}','[',']'的字符串s，判断字符串是否有效
 * 有效字符串必须满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合
 * 示例：s="()" -> true   s="(){}[]" -> true   s="(]" -> false  s="({)}" -> false
 */
public class Question20 {
    //字典
    Map<Character,Character> map = new HashMap<Character,Character>(){
        {
            put(')','(');
            put(']','[');
            put('}','{');
        }
    };
    public boolean solution(String str){
        Deque deque = new LinkedList();
        //奇数个括号一定无法配对
        if(str.length() % 2 == 1){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            //与栈顶元素匹配
            if(map.containsKey(str.charAt(i))){
                if(deque.isEmpty() || map.get(str.charAt(i)) != deque.pop()){
                    return false;
                }
            }
            else {
                deque.push(str.charAt(i));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Question20 question20 = new Question20();
        System.out.println(question20.solution(""));
    }
}
