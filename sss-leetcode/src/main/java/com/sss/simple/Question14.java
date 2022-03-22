package com.sss.simple;

import java.util.HashMap;
import java.util.Map;

/** @title:最长公共前缀
 *  @Author:杀神松1997
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 */
public class Question14 {
    //横向扫描
    public String solutionOne(String[]str){
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            prefix = compareResult(prefix, str[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public String compareResult(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (length > index){
            if(str1.charAt(index) != str2.charAt(index)){
                break;
            }
            index++;
        }
        return str1.substring(0,index);
    }

    //纵向扫描
    public String solutionTwo(String[]str){
        String prefix = str[0];
        for (int i = 0; i < str[0].length(); i++) {
            char current = str[0].charAt(i);
            for (int j = 1; j < str.length; j++) {
                if(i == str[j].length() || str[j].charAt(i) != current){
                    return str[0].substring(0,i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args) {
        Question14 question14 = new Question14();
        System.out.println(question14.solutionTwo(new String[]{"hello","hel","helav"}));
    }
}
