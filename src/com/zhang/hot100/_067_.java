package com.zhang.hot100;

/**
 * ClassName: _067_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 0:16
 * @Version 1.0
 */
public class _067_ {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        new _067_().findMin(nums);

    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    int findMin(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }

        if(left > right){
            return Integer.MAX_VALUE;
        }

        if(right - left == 1){
            return Math.min(nums[left], nums[right]);
        }

        int mid = left + (right - left)/2;
        if(nums[mid] > nums[right]){
            return Math.min(nums[left], findMin(nums, mid, right));
        }else{
            return Math.min(nums[mid], findMin(nums, left, mid-1));
        }
    }

}
