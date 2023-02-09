package com.sss.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** @title:括号生成
 *  @Author:杀神松1997
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 */

public class Question22 {

    //杀神松解
    public static List<String> mySolution(int n) {
        Deque<Character> deque = new LinkedList<>();
        List<String> result = new ArrayList<>();
        backTrace(0,result,deque,new StringBuffer(),n,0);
        return result;
    }

    public static void backTrace(int index,List<String> result,Deque<Character> deque,StringBuffer combination,int n,int count) {
      if(index == n * 2){
          result.add(combination.toString());
      }
      else {
          for (int i = 0; i < 2; i++) {
              if(i==0){
                  //最多有n个左括号,最后一个选择必定不是左括号
                  if(count >= n || index == n * 2 - 1){
                      continue;
                  }
                  deque.addFirst('(');
                  combination.append("(");
                  //选择左括号，左括号数量+1
                  count++;
                  backTrace(index+1,result,deque,combination,n,count);
                  //回溯还原(还原变量,还原栈,还原count)
                  combination.deleteCharAt(index);
                  deque.removeFirst();
                  count--;
              }
              //栈为空必定不能选择右括号
              else if(i == 1){
                  if(deque.isEmpty()){
                      continue;
                  }
                  deque.removeFirst();
                  combination.append(")");
                  backTrace(index+1,result,deque,combination,n,count);
                  //回溯还原
                  combination.deleteCharAt(index);
                  deque.addFirst('(');
              }
          }
      }
    }
    public static void main(String[] args) {
        Question22.mySolution(3);
    }
}
