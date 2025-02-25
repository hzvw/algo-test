package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _089_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 15:32
 * @Version 1.0
 */
public class _089_ {
    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        int bag = sum / 2;
        int[] w = nums;
        int[] v = nums;
        int m = w.length;
        int n = bag + 1;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if(j >= w[0]){
                dp[0][j] = w[0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        return dp[m-1][n-1] == bag;
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }

        int bag = sum / 2;
        int[] dp = new int[bag+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bag; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[bag] == bag;
    }

    public static void main(String[] args) {
        int[] w = {1,3,4};
        int[] v = {15,20,30};
        int bag = 4;

        System.out.println(new _089_().m1(w, v, bag));
    }


    // 01背包问题
    public int m1(int[] w, int[] v, int bag){
        int m = w.length;
        int n = bag+1;
        int[][] dp = new int[m][n];
        // dp[i][j]的含义是，考虑0-i的物品，容量为j的背包所能装的最大价值
        for (int j = 0; j < n; j++) {
            dp[0][j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        return dp[m-1][n-1];
    }

}
