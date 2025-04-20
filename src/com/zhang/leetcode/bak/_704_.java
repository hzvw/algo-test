package com.zhang.leetcode.bak;

/**
 * ClassName: _704_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 16:30
 * @Version 1.0
 */
public class _704_ {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(target > nums[mid]){
                left = mid+1;
            }else if(target < nums[mid]){
                right = mid-1;
            }else {
                return mid;
            }

        }

        return -1;
    }
}
