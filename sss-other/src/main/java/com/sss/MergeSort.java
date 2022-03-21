package com.sss;

import java.util.Arrays;

//归并排序 分治法分而治之 杀神松1997
public class MergeSort {
    public int[]sort(int arr[]){
        if(arr.length < 2){
            return arr;
        }
        int n = (int) Math.floor(arr.length / 2);
        int left[] = Arrays.copyOfRange(arr,0,n);
        int right[] = Arrays.copyOfRange(arr,n,arr.length);
        return merge(sort(left),sort(right));
    }
    public int[] merge(int left[],int right[]){
        int count = 0;
        int [] result = new int[left.length + right.length];
        while (left.length > 0 && right.length >0){
            if(left[0] <= right[0]){
                result[count] = left[0];
                //移动元素
                left = Arrays.copyOfRange(left,1,left.length);
                count++;
            }
            else {
                result[count] = right[0];
                //移动元素
                right = Arrays.copyOfRange(right,1,right.length);
                count++;
            }
        }
        if (left.length > 0){
            for (int i = 0; i < left.length; i++) {
                result[count] = left[i];
                count++;
            }
        }
        if (right.length > 0){
            for (int i = 0; i < right.length; i++) {
                result[count] = right[i];
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(new int[]{1,2,5,1,7,8,5,14})));
    }
}
