package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _085_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 1:38
 * @Version 1.0
 */
public class _085_ {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        if(coins == null || coins.length == 0){
            return 0;
        }

        int n = amount + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < n; j++) {
                if(dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];
    }

}
