package com.sss.simple;

import java.util.Arrays;

/** @title:二叉树的中序遍历
 *  @Author:杀神松1997
 *  给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Question94 {
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    //官方解,双指针
    public static void mySolution(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public static void main(String[] args) {

    }
}
