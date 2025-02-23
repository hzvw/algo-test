package com.zhang.datastruct;

import java.awt.*;

/**
 * ClassName: HeapSort
 * Package: com.zhang.datastruct
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/23 19:53
 * @Version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {6,5,4,2,1,3};
        new HeapSort().heap_sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    void heap_sort(int[] arr){
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        while (size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    void heapInsert(int[] arr, int i){
        while (arr[i] > arr[(i-1)/2]){
            swap(arr, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    void heapify(int[] arr, int i, int size){
        int l = i * 2 + 1;
        while (l < size){
            int best = l + 1 < size  && arr[l+1] > arr[l] ? l+1: l;
            best = arr[best] > arr[i] ? best : i;
            if(best == i){
                break;
            }
            swap(arr, best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }



}
