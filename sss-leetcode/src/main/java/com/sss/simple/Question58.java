package com.sss.simple;

/** @title:最后一个单词的长度
 *  @Author:杀神松1997
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 */
public class Question58 {

    //杀神松解
    public static int mySolution(String s){
        if(s != null && s.length() != 0){
            String strTrim = s.trim();
            return strTrim.substring(strTrim.lastIndexOf(" ")+1,strTrim.length()).length();
        }
        return 0;
    }

    

    public static void main(String[] args) {
        System.out.println(Question58.mySolution("   fly me   to   the moon  "));
    }
}
