package com.sss.middle;

import com.sss.repository.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @title:删除链表的倒数第n个结点
 *  @Author:杀神松1997
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 示例 1：
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 */
public class Question19 {

    //杀神松解
    public static ListNode mySolution(ListNode head, int n) {
        ListNode result = new ListNode(0);
        ListNode cursor = new ListNode();
        cursor = head;
        int length = 0;
        while (cursor != null){
            cursor = cursor.next;
            length++;
        }
        cursor = result;
        int point = length - n;
        for (int i = 0; i < length; i++) {
            if(i != point){
                cursor.next = new ListNode(head.val);
                cursor = cursor.next;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
