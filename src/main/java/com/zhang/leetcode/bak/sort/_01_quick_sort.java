package com.zhang.leetcode.bak.sort;

public class _01_quick_sort {
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void quick_sort(int[] nums, int left, int right){
        if(left > right){
            return;
        }

        int i = left;
        int j = right;

        int key = nums[left];
        while (i < j){
            while (i < j && nums[j] >= key){
                j--;
            }
            while (i < j && nums[i] <= key){
                i++;
            }
            if(i < j){
                swap(nums, i, j);
            }
        }

        nums[left] = nums[i];
        nums[i] = key;
        quick_sort(nums, left, i-1);
        quick_sort(nums, i+1, right);
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,5};
        new _01_quick_sort().quick_sort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
