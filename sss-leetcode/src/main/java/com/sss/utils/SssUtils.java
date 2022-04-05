package com.sss.utils;

import com.sss.repository.ListNode;
import com.sss.simple.Question83;

import java.util.StringJoiner;

public class SssUtils {
    //转成字符串验证测试
    public static String toString(ListNode listNode){
        StringJoiner sj = new StringJoiner("->");
        while (listNode != null){
            sj.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
        return sj.toString();
    }
}
