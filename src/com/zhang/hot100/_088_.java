package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _088_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 14:36
 * @Version 1.0
 */
public class _088_ {

    public static void main(String[] args) {
        int[] nums = {-2,3,-4};

        new _088_().maxProduct(nums);


    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];//以nums[i]结尾的最小乘积
        dp[0][1] = nums[0];//以nums[i]结尾的最大乘积

        for (int i = 1; i < n; i++) {
            int a = dp[i-1][0];
            int b = dp[i-1][1];
            int c = nums[i];

            dp[i][0] = min(c, a * c, b * c);
            dp[i][1] = max(c, a * c, b * c);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    int max(int a, int b, int c){
        return Math.max(Math.max(a,b), c);
    }

    int min(int a, int b, int c){
        return Math.min(Math.min(a,b), c);
    }
}
