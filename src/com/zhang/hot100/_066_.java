package com.zhang.hot100;

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

        int left = 0;
        int right = n-1;
        while (left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[right]){
                // 前有序，包括中间数
                // 6 7 8 9 1 2
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                // 后有序，包括中间数
                // 6 7 1 2 3 4 5 6
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        if(target == nums[left]){
            return left;
        }
        return  -1;
    }

}
