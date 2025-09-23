package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _083_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 0:52
 * @Version 1.0
 */
public class _083_ {

    public int rob1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(n < 2){
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(n < 2){
            return nums[0];
        }

        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
