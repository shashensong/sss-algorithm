package com.sss.middle;

import com.sss.repository.ListNode;
import com.sss.utils.SssUtils;

/** @title:两数相加
 *  @Author:杀神松1997
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Question02 {

    public static ListNode solution(ListNode n1, ListNode n2){
        int carry = 0;
        ListNode current = new ListNode(0);
        ListNode cursor = current;
        while(n1 != null || n2 != null){
            int val1 = n1 != null ? n1.val:0;
            int val2 = n2 != null ? n2.val:0;
            int sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode sumNode = new ListNode(sum);
            cursor.next = sumNode;
            cursor = cursor.next;
            if(n1 != null){
                n1 = n1.next;
            }
            if(n2 != null){
                n2 = n2.next;
            }
        }
        if (carry > 0) {
            cursor.next = new ListNode(carry);
        }
        return current.next;
    }

    public static void main(String[] args) {
        System.out.println(SssUtils.toString(Question02.solution(new ListNode(2,new ListNode(4,new ListNode(5))),new ListNode(5,new ListNode(6,new ListNode(4))))));
    }
}
