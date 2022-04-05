package com.sss;

import java.util.Deque;
import java.util.LinkedList;

//判断是否为完全二叉树
public class IsCompleteTree {
    static class Node{
        int val;
        Node left;
        Node right;
    }
    public static boolean isCompleteTree(Node root){
        if(root == null){
            return true;
        }
        Deque<Node> deque = new LinkedList();
        Node node = root;
        while (node != null){
           deque.offer(node.left);
           deque.offer(node.right);
            node = deque.poll();
        }
        while (!deque.isEmpty()){
            Node current = deque.poll();
            if(current != null){
                return false;
            }
        }
        return true;
    }
}
