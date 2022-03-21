package com.sss;

import java.util.Arrays;

//冒泡排序 杀神松1997
public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(new int[]{1,2,5,1,7,8,5,14})));
    }
}
