package com.zhang.hot100;

import com.sun.source.tree.ReturnTree;

/**
 * ClassName: _066_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 0:03
 * @Version 1.0
 */
public class _066_ {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        return search(nums, 0, n-1, target);
    }

    int search(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }

        if(left == right && nums[left] == target){
            return left;
        }

        int mid = left + (right - left)/2;
        if(nums[mid] > nums[right]){
            //左边有序
            if(target >= nums[left] && target < nums[mid]){
                // 在左边区间
                //普通的二分搜索
                return bs(nums, left, mid-1, target);
            }else if(target>=nums[left] && target == nums[mid]){
                return mid;

            }else{
                // 在右边区间
                //
                return search(nums, mid+1, right, target);
            }

        }else{
            //右边有序
            if(target <= nums[right] && target > nums[mid]){
                return bs(nums, mid+1, right, target);
            }else if(target <= nums[right] && target == nums[mid]){
                return mid;
            }else{
                return search(nums, left, mid-1, target);
            }

        }
    }


    int bs(int[] nums, int left, int right, int target){
        if(left == right && nums[left] == target){
            return left;
        }
        if(left > right){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(nums[mid] > target){
            return bs(nums, left, mid-1, target);
        }else if(nums[mid] < target){
            return bs(nums, mid+1, right, target);
        }else{
            return mid;
        }
    }


}
