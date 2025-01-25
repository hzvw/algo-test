package com.zhang.hot100;

public class Solution {
    public int splitArray(int[] nums, int k) {
        return helper(nums, 0, k, 0, 0);
    }

    // helper函数表示从 nums[index:] 这个子数组开始，分成 k 个子数组的最小最大和
    private int helper(int[] nums, int index, int k, int currentSum, int subArrayMax) {
        // 基础情况，如果k == 1，表示已经分成了 k-1 个子数组，剩下的部分就是最后一个子数组
        if (k == 1) {
            // 计算当前子数组和的最大值
            int remainingMax = Math.max(subArrayMax, sum(nums, index));
            return remainingMax;
        }
        
        // 递归尝试所有可能的分割点
        int result = Integer.MAX_VALUE;
        int sum = 0;
        
        // 从当前 index 开始，尝试将剩余的部分划分成 k 个子数组
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];  // 累加当前子数组的和
            result = Math.min(result, helper(nums, i + 1, k - 1, sum, Math.max(subArrayMax, sum)));
        }
        
        return result;
    }

    // 计算从 index 到数组末尾的和
    private int sum(int[] nums, int start) {
        int sum = 0;
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(solution.splitArray(nums, k));  // Output: 18
    }
}
