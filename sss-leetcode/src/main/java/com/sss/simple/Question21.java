package com.sss.simple;

import java.util.Optional;
import java.util.StringJoiner;

/** @title:合并两个有序链表
 *  @Author:杀神松1997
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 示例： Node1: 1->2->4   Node2: 1->3->4  resultNode: 1->1->2->3->4->4
 * Node1: null Node2: null resultNode:null
 * Node1: null Node2: 0    resultNode:0
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
