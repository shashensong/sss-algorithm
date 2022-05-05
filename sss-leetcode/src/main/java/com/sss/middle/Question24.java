package com.sss.middle;

import com.sss.repository.ListNode;

/** @title:两两交换链表中的结点
 *  @Author:杀神松1997
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 */

public class Question24 {

    //杀神松解
    public static ListNode mySolution(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode result = new ListNode();
        ListNode cursor = result;
        ListNode pre = null;
        int count = 0;
        while (head != null){
            //偶数位
            if(count % 2 == 0){
                if(head.next == null){
                    cursor.next = new ListNode(head.val);
                }
                else {
                    cursor.next = new ListNode(head.next.val);
                }
            }
            //奇数位
            else {
                cursor.next = new ListNode(pre.val);
            }
            cursor = cursor.next;
            pre = new ListNode(head.val);
            head = head.next;
            count++;
        }
       return result.next;
    }



    public static void main(String[] args) {

    }
}
