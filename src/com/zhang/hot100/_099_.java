package com.zhang.hot100;

/**
 * ClassName: _099_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 20:36
 * @Version 1.0
 */
public class _099_ {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n-2;
        while (i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n-1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i ,j);
        }
        reverse(nums, i+1);
    }

    void swap(int[] nums, int i, int j){
        int t= nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int start){
        int left = start;
        int right = nums.length-1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
