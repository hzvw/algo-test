package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _084_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 1:15
 * @Version 1.0
 */
public class _084_ {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i*i < n+1; i++) {
            for (int j = i*i; j < n+1; j++) {
                if(dp[j-i*i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
                }
            }
        }

        return dp[n];
    }
}
