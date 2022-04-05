package com.sss.simple;

import java.util.StringJoiner;

/** @title:删除排序链表中的重复元素
 *  @Author:杀神松1997
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例1
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例2
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Question83 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }
    }
    //杀神松解
    public static ListNode mySolution(ListNode head){
        if(head == null){
            return null;
        }
        ListNode current = head.next;
         while(current != null && head.val == current.val){
             current = current.next;
         }
         //递归删除
         head.next = mySolution(current);
         return head;
    }
    //转成字符串验证测试
    public static String toString(ListNode listNode){
        StringJoiner sj = new StringJoiner("->");
        while (listNode != null){
            sj.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        System.out.println(toString(Question83.mySolution(new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,null))))))));
    }
}
