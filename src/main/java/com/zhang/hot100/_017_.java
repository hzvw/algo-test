package com.zhang.hot100;

/**
 * ClassName: _017_
 * Package: com.zhang.hot100
 * Description:缺失的第一个正数
 *
 * @Author Harizon
 * @Create 2025/2/18 18:29
 * @Version 1.0
 */
public class _017_ {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new _017_().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return n+1;
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
