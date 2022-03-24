package com.sss.simple;

import java.util.Optional;
import java.util.StringJoiner;

/** @title:加一
 *  @Author:杀神松1997
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Question21 {
    static class Node{
        int value;
        Node next;

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    //杀神松解
    public static Node mySolution(Node n1,Node n2){
        Node result = null;
        if(!Optional.ofNullable(n1).isPresent()){
            return n2;
        }
        if(!Optional.ofNullable(n2).isPresent()){
            return n1;
        }
        if(n1.value > n2.value){
            result=new Node(n2.value,mySolution(n1,n2.next));
        }
        else {
            result=new Node(n1.value,mySolution(n1.next,n2));
        }
        return result;
    }

    //转成字符串验证测试
    public static String toString(Node node){
        StringJoiner sj = new StringJoiner("->");
        while (node != null){
            sj.add(String.valueOf(node.value));
            node = node.next;
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1,new Node(2,new Node(4,null)));
        Node n2 = new Node(1,new Node(3,new Node(4,null)));
        System.out.println(toString(Question21.mySolution(n1,n2)));
    }
}
