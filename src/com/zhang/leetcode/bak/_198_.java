package com.zhang.leetcode.bak;

/**
 * ClassName: _198_
 * Package: com.zhang.leetcode.bak
 * Description:https://leetcode.cn/problems/house-robber/description/
 * 打家劫舍
 *
 * @Author Harizon
 * @Create 2025/2/15 23:19
 * @Version 1.0
 */
public class _198_ {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        int ans = new _198_().rob(nums);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

}
